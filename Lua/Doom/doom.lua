-- Basic Doom prototype

-- Initialize game state
local game = {
    running = true,
    player = { x = 10, y = 10, angle = 0, speed = 2 },
    map = {
        {1, 1, 1, 1, 1},
        {1, 0, 0, 0, 1},
        {1, 0, 1, 0, 1},
        {1, 0, 0, 0, 1},
        {1, 1, 1, 1, 1},
    }
}

-- Render the map and player
local function render()
    for y, row in ipairs(game.map) do
        for x, cell in ipairs(row) do
            io.write(cell == 1 and "#" or ".")
        end
        io.write("\n")
    end
    print("Player position: (" .. game.player.x .. ", " .. game.player.y .. ")")
end

-- Update player position based on input
local function update(input)
    if input == "w" then
        game.player.y = game.player.y - game.player.speed
    elseif input == "s" then
        game.player.y = game.player.y + game.player.speed
    elseif input == "a" then
        game.player.x = game.player.x - game.player.speed
    elseif input == "d" then
        game.player.x = game.player.x + game.player.speed
    elseif input == "q" then
        game.running = false
    end
end

-- Game loop
while game.running do
    render()
    print("Enter command (w/a/s/d to move, q to quit):")
    local input = io.read()
    update(input)
end

print("Game Over")
