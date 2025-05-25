-- Game state
local game = {
    state = "menu", -- "menu", "playing", or "gameover"
    mode = "single", -- "single", "two", or "versus" for player mode
    bestScore = 0,
    players = {
        { x = 290, y = 550, speed = 400, bullets = {}, shootCooldown = 0, lives = 3, controls = { up = "w", down = "s", left = "a", right = "d", shoot = "space" } },
        { x = 310, y = 550, speed = 400, bullets = {}, shootCooldown = 0, lives = 3, controls = { up = "up", down = "down", left = "left", right = "right", shoot = "rshift" } }
    },
    enemies = {},
    enemyBullets = {},
    bulletSpeed = 500,
    enemySpeed = 100,
    enemyBulletSpeed = 300,
    explosionDuration = 0.5, -- Duration of explosion animation in seconds
    shootInterval = 0.2, -- Time between player shots in seconds
    enemyShootInterval = 0.5, -- Time between enemy shots in seconds
    spawnInterval = 2.5, -- Time between enemy spawns
    spawnCooldown = 0,
    score = 0,
    allies = {} -- Add allies for versus mode
}

local playerHitAnimation = {}

-- Load resources
function love.load()
    love.window.setTitle("2D Shooter 2025")
    love.window.setMode(600, 600) -- Set window size to 600x600

    -- Initialize player hit animation
    playerHitAnimation.active = false
    playerHitAnimation.timer = 0
    playerHitAnimation.duration = 0.3 -- Animation lasts 0.3 seconds

    -- Load best score from file
    if love.filesystem.getInfo("best_score.txt") then
        local contents = love.filesystem.read("best_score.txt")
        game.bestScore = tonumber(contents) or 0
    end
end

-- Save the best score to a file
local function saveBestScore()
    love.filesystem.write("best_score.txt", tostring(game.bestScore))
end

-- Add a new mode for versus
local function resetGame(mode)
    game.state = "playing"
    game.mode = mode
    game.score = 0
    game.spawnCooldown = (mode == "versus") and nil or game.spawnInterval -- Properly initialize spawnCooldown
    game.enemies = {} -- Remove enemies in versus mode
    game.enemyBullets = {} -- Remove enemy bullets in versus mode
    game.allies = {} -- Remove allies in versus mode
    for i, player in ipairs(game.players) do
        if mode == "versus" then
            player.x = 290
            player.y = (i == 1) and 50 or 550 -- Player 1 at the top, Player 2 at the bottom
            player.lives = 7 -- 7 lives in versus mode
        else
            player.x = 290 + (i - 1) * 20
            player.y = 550
            player.lives = 3 -- Reset to 3 lives for other modes
        end
        player.bullets = {}
        player.shootCooldown = 0
        player.passedEnemies = 0 -- Track how many enemies have passed each player
    end
end

-- Render the menu with modern aesthetics
local function renderMenu()
    love.graphics.clear(0.1, 0.1, 0.2) -- Dark blue background
    love.graphics.setColor(0.8, 0.8, 1) -- Light blue text
    love.graphics.printf("2D Shooter 2025", 0, 100, 600, "center")
    love.graphics.printf("Press 1 for Single Player", 0, 200, 600, "center")
    love.graphics.printf("Press 2 for Two Players", 0, 250, 600, "center")
    love.graphics.printf("Press 3 for Versus Mode", 0, 300, 600, "center")
    love.graphics.printf("Press Escape to Quit", 0, 350, 600, "center")
    love.graphics.printf("Best Score: " .. game.bestScore, 0, 400, 600, "center")
end

-- Render the game over screen with the winner in versus mode
local function renderGameOver()
    love.graphics.clear(0.1, 0.1, 0.2) -- Dark blue background
    love.graphics.setColor(1, 0.5, 0.5) -- Light red text
    if game.mode == "versus" then
        local winner = game.players[1].lives > 0 and "Player 1" or "Player 2"
        love.graphics.printf(winner .. " Wins!", 0, 150, 600, "center")
    else
        love.graphics.printf("Game Over", 0, 150, 600, "center")
        love.graphics.printf("Score: " .. game.score, 0, 250, 600, "center")
        love.graphics.printf("Best Score: " .. game.bestScore, 0, 300, 600, "center")
    end
    love.graphics.printf("Press Enter to Restart", 0, 350, 600, "center")
    love.graphics.printf("Press Escape to Quit", 0, 400, 600, "center")
end

-- Render the player, bullets, and damage animation
local function renderGame()
    -- Background gradient
    local r, g, b = 0.1, 0.1, 0.2
    for i = 0, 600, 2 do
        love.graphics.setColor(r, g, b)
        love.graphics.rectangle("fill", 0, i, 600, 2)
        r = r + 0.0001
        g = g + 0.0002
        b = b + 0.0003
    end

    -- Render players
    for i, player in ipairs(game.players) do
        if player.lives > 0 then -- Only render players who are still alive
            love.graphics.setColor(i == 1 and {0, 1, 0.5} or {0, 0.5, 1}) -- Different colors for players
            love.graphics.rectangle("fill", player.x, player.y, 20, 20, 5, 5)

            -- Render player hit animation for each player
            if playerHitAnimation.active and playerHitAnimation.target == i then
                love.graphics.setColor(1, 0, 0, 0.5) -- Semi-transparent red overlay
                love.graphics.rectangle("fill", player.x - 5, player.y - 5, 30, 30)
            end
        end
    end

    -- Render bullets
    love.graphics.setColor(1, 1, 0) -- Neon yellow for bullets
    for _, player in ipairs(game.players) do
        if game.mode == "single" and player ~= game.players[1] then break end
        for _, bullet in ipairs(player.bullets) do
            love.graphics.rectangle("fill", bullet.x, bullet.y, 5, 5, 2, 2)
        end
    end

    -- Render enemies
    for _, enemy in ipairs(game.enemies) do
        if enemy.alive then
            love.graphics.setColor(1, 0, 0.5) -- Neon pink for alive enemies
            love.graphics.rectangle("fill", enemy.x, enemy.y, 20, 20, 5, 5)
        elseif enemy.explosionTimer > 0 then
            love.graphics.setColor(1, 0.5, 0) -- Neon orange for explosion
            love.graphics.circle("fill", enemy.x + 10, enemy.y + 10, 15)
        end
    end

    -- Render score
    love.graphics.setColor(1, 1, 1)
    love.graphics.print("Score: " .. game.score, 10, 10)

    -- Render player lives below the score
    for i, player in ipairs(game.players) do
        if game.mode == "single" and i > 1 then break end
        love.graphics.setColor(1, 0, 0) -- Red for hearts
        local hearts = string.rep("♥ ", player.lives)
        love.graphics.print("P" .. i .. ": " .. hearts, 10, 30 + (i - 1) * 20)
    end

    -- Render enemy bullets
    love.graphics.setColor(1, 0.5, 0) -- Orange for enemy bullets
    for _, bullet in ipairs(game.enemyBullets) do
        love.graphics.rectangle("fill", bullet.x, bullet.y, 5, 5, 2, 2)
    end
end

-- Update player movement and shooting
local function updatePlayers(dt)
    for i, player in ipairs(game.players) do
        if game.mode == "single" and i > 1 then break end
        if player.lives <= 0 then
            player.bullets = {} -- Clear bullets of dead players
            goto continue -- Skip dead players
        end

        -- Movement
        if love.keyboard.isDown(player.controls.up) then
            player.y = math.max(0, player.y - player.speed * dt)
        end
        if love.keyboard.isDown(player.controls.down) then
            player.y = math.min(580, player.y + player.speed * dt)
        end
        if love.keyboard.isDown(player.controls.left) then
            player.x = math.max(0, player.x - player.speed * dt)
        end
        if love.keyboard.isDown(player.controls.right) then
            player.x = math.min(580, player.x + player.speed * dt)
        end

        -- Shooting
        if love.keyboard.isDown(player.controls.shoot) then
            if player.shootCooldown <= 0 then
                if game.mode == "versus" then
                    table.insert(player.bullets, { x = player.x + 7.5, y = player.y, direction = (i == 1) and "down" or "up" })
                else
                    table.insert(player.bullets, { x = player.x + 7.5, y = player.y })
                end
                player.shootCooldown = game.shootInterval
            end
        end
        if player.shootCooldown > 0 then
            player.shootCooldown = player.shootCooldown - dt
        end

        -- Update bullets
        for j = #player.bullets, 1, -1 do
            local bullet = player.bullets[j]
            if game.mode == "versus" then
                if bullet.direction == "down" then
                    bullet.y = bullet.y + game.bulletSpeed * dt
                    if bullet.y > 600 then
                        table.remove(player.bullets, j)
                    end
                elseif bullet.direction == "up" then
                    bullet.y = bullet.y - game.bulletSpeed * dt
                    if bullet.y < 0 then
                        table.remove(player.bullets, j)
                    end
                end
            else
                bullet.y = bullet.y - game.bulletSpeed * dt
                if bullet.y < 0 then
                    table.remove(player.bullets, j)
                end
            end
        end

        ::continue::
    end
end

-- Check for collisions between bullets and enemies or player
local function checkCollisions()
    for i, player in ipairs(game.players) do
        if game.mode == "single" and i > 1 then break end

        -- Check for collisions between player bullets and enemies
        for i = #player.bullets, 1, -1 do
            local bullet = player.bullets[i]
            for j = #game.enemies, 1, -1 do
                local enemy = game.enemies[j]
                if enemy.alive and
                   bullet.x < enemy.x + 20 and bullet.x + 5 > enemy.x and
                   bullet.y < enemy.y + 20 and bullet.y + 5 > enemy.y then
                    -- Enemy hit
                    enemy.alive = false
                    enemy.explosionTimer = game.explosionDuration
                    table.remove(player.bullets, i)
                    game.score = game.score + 1
                    if game.score > game.bestScore then
                        game.bestScore = game.score
                        saveBestScore()
                    end
                    break
                end
            end
        end

        -- Check for enemy bullets hitting the player
        for j = #game.enemyBullets, 1, -1 do
            local bullet = game.enemyBullets[j]
            if bullet.x < player.x + 20 and bullet.x + 5 > player.x and
               bullet.y < player.y + 20 and bullet.y + 5 > player.y then
                -- Player hit
                table.remove(game.enemyBullets, j)
                player.lives = player.lives - 1

                -- Trigger player hit animation for the specific player
                playerHitAnimation.active = true
                playerHitAnimation.timer = playerHitAnimation.duration
                playerHitAnimation.target = i -- Track which player was hit

                if player.lives <= 0 then
                    if game.mode == "two" then
                        -- In two-player mode, one player's death does not end the game for the other
                        local otherPlayerAlive = false
                        for _, p in ipairs(game.players) do
                            if p.lives > 0 then
                                otherPlayerAlive = true
                                break
                            end
                        end
                        if not otherPlayerAlive then
                            game.state = "gameover"
                        end
                    else
                        game.state = "gameover"
                    end
                end
            end
        end
    end
end

-- Update player hit animation
local function updatePlayerHitAnimation(dt)
    if playerHitAnimation.active then
        playerHitAnimation.timer = playerHitAnimation.timer - dt
        if playerHitAnimation.timer <= 0 then
            playerHitAnimation.active = false
            playerHitAnimation.target = nil -- Clear the target
        end
    end
end

-- Update enemies (adjust for new resolution and shooting)
local function updateEnemies(dt)
    if game.mode == "versus" then return end -- Skip enemy updates in versus mode

    -- Spawn new enemies
    if game.spawnCooldown then
        game.spawnCooldown = game.spawnCooldown - dt
        if game.spawnCooldown <= 0 then
            table.insert(game.enemies, {
                x = math.random(20, 580), -- Adjust for new width
                y = -20,
                alive = true,
                explosionTimer = 0,
                shootCooldown = game.enemyShootInterval
            })
            game.spawnCooldown = game.spawnInterval
        end
    end

    -- Update existing enemies
    for i = #game.enemies, 1, -1 do
        local enemy = game.enemies[i]
        if enemy.alive then
            enemy.y = enemy.y + game.enemySpeed * dt
            if enemy.y > 600 then -- Adjust for new height
                -- Enemy passed the player
                for _, player in ipairs(game.players) do
                    if player.lives > 0 then
                        player.passedEnemies = player.passedEnemies + 1
                        if player.passedEnemies >= 3 then
                            player.lives = player.lives - 1 -- Lose one life if 3 enemies pass
                            player.passedEnemies = 0 -- Reset passed enemies counter
                            if player.lives <= 0 then
                                -- Check if the game should end
                                local otherPlayerAlive = false
                                for _, p in ipairs(game.players) do
                                    if p.lives > 0 then
                                        otherPlayerAlive = true
                                        break
                                    end
                                end
                                if not otherPlayerAlive then
                                    game.state = "gameover"
                                end
                            end
                        end
                    end
                end
                table.remove(game.enemies, i) -- Remove enemies that fall off the screen
            else
                -- Enemy shooting
                enemy.shootCooldown = enemy.shootCooldown - dt
                if enemy.shootCooldown <= 0 then
                    table.insert(game.enemyBullets, { x = enemy.x + 7.5, y = enemy.y + 20 })
                    enemy.shootCooldown = game.enemyShootInterval
                end
            end
        elseif enemy.explosionTimer > 0 then
            enemy.explosionTimer = enemy.explosionTimer - dt
        end
    end

    -- Update enemy bullets
    for i = #game.enemyBullets, 1, -1 do
        local bullet = game.enemyBullets[i]
        bullet.y = bullet.y + game.enemyBulletSpeed * dt
        for _, player in ipairs(game.players) do
            if player.lives > 0 and
               bullet.x < player.x + 20 and bullet.x + 5 > player.x and
               bullet.y < player.y + 20 and bullet.y + 5 > player.y then
                -- Player hit
                table.remove(game.enemyBullets, i)
                player.lives = player.lives - 1

                -- Trigger player hit animation
                playerHitAnimation.active = true
                playerHitAnimation.timer = playerHitAnimation.duration
                playerHitAnimation.target = player == game.players[1] and 1 or 2 -- Track which player was hit

                if player.lives <= 0 then
                    -- Check if the game should end
                    local otherPlayerAlive = false
                    for _, p in ipairs(game.players) do
                        if p.lives > 0 then
                            otherPlayerAlive = true
                            break
                        end
                    end
                    if not otherPlayerAlive then
                        game.state = "gameover"
                    end
                end
                break
            end
        end
        if bullet.y > 600 then
            table.remove(game.enemyBullets, i)
        end
    end
end

-- Update allies in versus mode
local function updateAllies(dt)
    if game.mode == "versus" or not game.spawnCooldown then return end -- Skip ally updates in versus mode or if spawnCooldown is nil

    -- Spawn allies
    game.spawnCooldown = game.spawnCooldown - dt
    if game.spawnCooldown <= 0 then
        table.insert(game.allies, {
            x = math.random(20, 580),
            y = -20,
            direction = "down", -- Allies from the top move down
            color = {0.5, 1, 0} -- Green for top allies
        })
        table.insert(game.allies, {
            x = math.random(20, 580),
            y = 620,
            direction = "up", -- Allies from the bottom move up
            color = {1, 0.5, 0} -- Orange for bottom allies
        })
        game.spawnCooldown = game.allySpawnInterval -- Reset spawn cooldown to 6 seconds
    end

    -- Update allies
    for i = #game.allies, 1, -1 do
        local ally = game.allies[i]
        if ally.direction == "down" then
            ally.y = ally.y + game.enemySpeed * dt
            if ally.y > 600 then
                table.remove(game.allies, i)
            end
        elseif ally.direction == "up" then
            ally.y = ally.y - game.enemySpeed * dt
            if ally.y < -20 then
                table.remove(game.allies, i)
            end
        end
    end
end

-- Check for collisions between bullets and players in versus mode
local function checkVersusCollisions()
    if game.mode == "versus" then
        for i, player in ipairs(game.players) do
            if player.lives > 0 then
                for j = #player.bullets, 1, -1 do
                    local bullet = player.bullets[j]
                    local opponent = game.players[i == 1 and 2 or 1] -- Get the opponent
                    if opponent.lives > 0 and
                       bullet.x < opponent.x + 20 and bullet.x + 5 > opponent.x and
                       bullet.y < opponent.y + 20 and bullet.y + 5 > opponent.y then
                        -- Opponent hit
                        table.remove(player.bullets, j)
                        opponent.lives = opponent.lives - 1

                        -- Trigger damage animation
                        playerHitAnimation.active = true
                        playerHitAnimation.timer = playerHitAnimation.duration
                        playerHitAnimation.target = i == 1 and 2 or 1 -- Show animation on the opponent

                        -- Check if the game should end
                        if opponent.lives <= 0 then
                            game.state = "gameover"
                        end
                    end
                end
            end
        end
    end
end

-- LÖVE callback: Update game state
function love.update(dt)
    if game.state == "playing" then
        updatePlayers(dt)

        -- Update player hit animation
        updatePlayerHitAnimation(dt)

        -- Check for collisions and update enemies
        updateEnemies(dt)

        -- Update allies in versus mode
        updateAllies(dt)

        -- Check versus mode collisions
        checkVersusCollisions()
    end
end

-- LÖVE callback: Handle key presses
function love.keypressed(key)
    if game.state == "menu" then
        if key == "1" then
            resetGame("single")
        elseif key == "2" then
            resetGame("two")
        elseif key == "3" then
            resetGame("versus")
        elseif key == "escape" then
            love.event.quit()
        end
    elseif game.state == "playing" then
        if key == "escape" then
            love.event.quit()
        end
    elseif game.state == "gameover" then
        if key == "return" then
            game.state = "menu"
        elseif key == "escape" then
            love.event.quit()
        end
    end
end

-- LÖVE callback: Draw the game
function love.draw()
    if game.state == "menu" then
        renderMenu()
    elseif game.state == "playing" then
        renderGame()
    elseif game.state == "gameover" then
        renderGameOver()
    end
end
