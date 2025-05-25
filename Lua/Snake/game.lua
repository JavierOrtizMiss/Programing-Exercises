-- Load required libraries
function love.load()
    love.window.setTitle("Snake Game")
    love.window.setMode(800, 600)
    
    cellSize = 20
    gridWidth = love.graphics.getWidth() / cellSize
    gridHeight = love.graphics.getHeight() / cellSize

    snake = {
        body = { {x = 5, y = 5} },
        direction = "right",
        grow = false
    }

    food = {
        x = math.random(0, gridWidth - 1),
        y = math.random(0, gridHeight - 1)
    }

    gameOver = false
end

-- Handle input
function love.keypressed(key)
    if key == "up" and snake.direction ~= "down" then
        snake.direction = "up"
    elseif key == "down" and snake.direction ~= "up" then
        snake.direction = "down"
    elseif key == "left" and snake.direction ~= "right" then
        snake.direction = "left"
    elseif key == "right" and snake.direction ~= "left" then
        snake.direction = "right"
    end
end

-- Update game state
function love.update(dt)
    if gameOver then return end

    local head = snake.body[1]
    local newHead = {x = head.x, y = head.y}

    if snake.direction == "up" then
        newHead.y = newHead.y - 1
    elseif snake.direction == "down" then
        newHead.y = newHead.y + 1
    elseif snake.direction == "left" then
        newHead.x = newHead.x - 1
    elseif snake.direction == "right" then
        newHead.x = newHead.x + 1
    end

    -- Check for collisions with walls
    if newHead.x < 0 or newHead.y < 0 or newHead.x >= gridWidth or newHead.y >= gridHeight then
        gameOver = true
        return
    end

    -- Check for collisions with itself
    for _, segment in ipairs(snake.body) do
        if newHead.x == segment.x and newHead.y == segment.y then
            gameOver = true
            return
        end
    end

    table.insert(snake.body, 1, newHead)

    -- Check for food collision
    if newHead.x == food.x and newHead.y == food.y then
        snake.grow = true
        food.x = math.random(0, gridWidth - 1)
        food.y = math.random(0, gridHeight - 1)
    end

    if not snake.grow then
        table.remove(snake.body)
    else
        snake.grow = false
    end
end

-- Render game
function love.draw()
    if gameOver then
        love.graphics.printf("Game Over", 0, love.graphics.getHeight() / 2 - 10, love.graphics.getWidth(), "center")
        return
    end

    -- Draw snake
    for _, segment in ipairs(snake.body) do
        love.graphics.rectangle("fill", segment.x * cellSize, segment.y * cellSize, cellSize, cellSize)
    end

    -- Draw food
    love.graphics.rectangle("fill", food.x * cellSize, food.y * cellSize, cellSize, cellSize)
end
