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
    snakeSpeed = 0.1 -- Tiempo en segundos entre movimientos
    snakeTimer = 0
    score = 0

    -- Colores y diseño
    snakeColor = {0.2, 0.8, 0.2} -- Verde brillante para la serpiente
    foodColor = {0.9, 0.1, 0.1} -- Rojo brillante para la comida
    backgroundColor = {0.9, 0.9, 0.9} -- Fondo claro
    textColor = {0, 0, 0} -- Negro para el texto
    animationTimer = 0
    animationDuration = 0.5 -- Duración de la animación de la comida
    foodScale = 1

    -- Estado del juego
    gameState = "menu" -- Puede ser "menu", "playing", "gameover"

    font = love.graphics.newFont(24) -- Fuente personalizada
    love.graphics.setFont(font)

    -- Botones del menú
    buttons = {
        start = {x = 300, y = 200, width = 200, height = 50, text = "Start Game"},
        quit = {x = 300, y = 300, width = 200, height = 50, text = "Quit"}
    }

    targetFrameTime = 1 / 60 -- Tiempo objetivo por frame (60 FPS)
    controlMode = "keyboard" -- Puede ser "keyboard" o "mouse"
end

-- Handle input
function love.keypressed(key)
    if gameState == "menu" then
        if key == "return" then
            gameState = "playing"
            resetGame()
        elseif key == "escape" then
            love.event.quit()
        end
    elseif gameState == "playing" then
        if key == "escape" then
            gameState = "paused"
        elseif controlMode == "keyboard" then
            if key == "w" and snake.direction ~= "down" then
                snake.direction = "up"
            elseif key == "s" and snake.direction ~= "up" then
                snake.direction = "down"
            elseif key == "a" and snake.direction ~= "right" then
                snake.direction = "left"
            elseif key == "d" and snake.direction ~= "left" then
                snake.direction = "right"
            end
        end
    elseif gameState == "paused" then
        if key == "escape" then
            gameState = "playing"
        elseif key == "m" then
            controlMode = controlMode == "keyboard" and "mouse" or "keyboard"
        end
    elseif gameState == "gameover" then
        if key == "return" then
            gameState = "menu"
        elseif key == "escape" then
            love.event.quit()
        end
    end
end

-- Reinicia el juego
function resetGame()
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
    score = 0
    snakeTimer = 0
end

-- Update game state
function love.update(dt)
    if gameState == "menu" or gameState == "gameover" or gameState == "paused" then
        return
    end

    -- Limitar la lógica del juego a 60 FPS
    if dt > targetFrameTime then
        dt = targetFrameTime
    end

    -- Animación de la comida (cambio de tamaño)
    animationTimer = animationTimer + dt
    if animationTimer > animationDuration then
        animationTimer = animationTimer - animationDuration
    end
    foodScale = 1 + 0.2 * math.sin((animationTimer / animationDuration) * math.pi * 2)

    snakeTimer = snakeTimer + dt
    if snakeTimer < snakeSpeed then
        return
    end
    snakeTimer = 0

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
        gameState = "gameover"
        return
    end

    -- Check for collisions with itself
    for _, segment in ipairs(snake.body) do
        if newHead.x == segment.x and newHead.y == segment.y then
            gameOver = true
            gameState = "gameover"
            return
        end
    end

    table.insert(snake.body, 1, newHead)

    -- Check for food collision
    if newHead.x == food.x and newHead.y == food.y then
        snake.grow = true
        food.x = math.random(0, gridWidth - 1)
        food.y = math.random(0, gridHeight - 1)
        score = score + 1
    end

    if not snake.grow then
        table.remove(snake.body)
    else
        snake.grow = false
    end

    if controlMode == "mouse" then
        local mx, my = love.mouse.getPosition()
        local head = snake.body[1]
        if mx > head.x * cellSize + cellSize then
            snake.direction = "right"
        elseif mx < head.x * cellSize then
            snake.direction = "left"
        elseif my > head.y * cellSize + cellSize then
            snake.direction = "down"
        elseif my < head.y * cellSize then
            snake.direction = "up"
        end
    end
end

-- Render game
function love.draw()
    -- Fondo sólido
    love.graphics.clear(0.8, 0.9, 1) -- Azul claro sólido

    if gameState == "menu" then
        -- Dibujar botones del menú
        for _, button in pairs(buttons) do
            if isMouseOverButton(button) then
                love.graphics.setColor(0.7, 0.7, 0.7) -- Color más oscuro al pasar el mouse
            else
                love.graphics.setColor(1, 1, 1) -- Color normal
            end
            love.graphics.rectangle("fill", button.x, button.y, button.width, button.height, 10)
            love.graphics.setColor(0, 0, 0) -- Texto negro
            love.graphics.printf(button.text, button.x, button.y + 15, button.width, "center")
        end
    elseif gameState == "playing" then
        -- Dibujar serpiente
        love.graphics.setColor(snakeColor)
        for _, segment in ipairs(snake.body) do
            love.graphics.rectangle("fill", segment.x * cellSize, segment.y * cellSize, cellSize, cellSize)
        end

        -- Dibujar comida
        love.graphics.setColor(foodColor)
        love.graphics.rectangle("fill", food.x * cellSize, food.y * cellSize, cellSize, cellSize)

        -- Dibujar puntaje
        love.graphics.setColor(textColor)
        love.graphics.print("Score: " .. score, 10, 10)
    elseif gameState == "paused" then
        love.graphics.setColor(0, 0, 0)
        love.graphics.printf("Paused", 0, 150, love.graphics.getWidth(), "center")
        love.graphics.printf("Press Escape to Resume", 0, 200, love.graphics.getWidth(), "center")
        love.graphics.printf("Press M to Toggle Control Mode", 0, 250, love.graphics.getWidth(), "center")
    elseif gameState == "gameover" then
        -- Dibujar pantalla de Game Over
        love.graphics.setColor(0, 0, 0)
        love.graphics.printf("Game Over", 0, 150, love.graphics.getWidth(), "center")
        love.graphics.printf("Score: " .. score, 0, 200, love.graphics.getWidth(), "center")

        -- Dibujar botones del menú
        for _, button in pairs(buttons) do
            if isMouseOverButton(button) then
                love.graphics.setColor(0.7, 0.7, 0.7) -- Color más oscuro al pasar el mouse
            else
                love.graphics.setColor(1, 1, 1) -- Color normal
            end
            love.graphics.rectangle("fill", button.x, button.y, button.width, button.height, 10)
            love.graphics.setColor(0, 0, 0) -- Texto negro
            love.graphics.printf(button.text, button.x, button.y + 15, button.width, "center")
        end
    end
end

-- Detecta si el mouse está sobre un botón
function isMouseOverButton(button)
    local mx, my = love.mouse.getPosition()
    return mx >= button.x and mx <= button.x + button.width and my >= button.y and my <= button.y + button.height
end

-- Maneja clics del mouse
function love.mousepressed(x, y, button)
    if button == 1 and gameState == "menu" then
        if isMouseOverButton(buttons.start) then
            gameState = "playing"
            resetGame()
        elseif isMouseOverButton(buttons.quit) then
            love.event.quit()
        end
    elseif button == 1 and gameState == "gameover" then
        if isMouseOverButton(buttons.start) then
            gameState = "menu"
        elseif isMouseOverButton(buttons.quit) then
            love.event.quit()
        end
    end
end

-- Dibuja un fondo degradado
function drawGradientBackground()
    love.graphics.clear(0.8, 0.9, 1) -- Azul claro sólido
end
