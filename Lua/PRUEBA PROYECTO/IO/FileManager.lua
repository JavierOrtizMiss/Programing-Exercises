local FileManager = {}

function FileManager:saveToFile(filename, contacts)
    local file = io.open(filename, "w")
    for _, contact in ipairs(contacts) do
        file:write(contact.name .. "," .. contact.birthday .. "," .. contact.phone .. "," .. contact.email .. "\n")
    end
    file:close()
end

function FileManager:loadFromFile(filename)
    local contacts = {}
    local file = io.open(filename, "r")
    if not file then return contacts end
    for line in file:lines() do
        local name, birthday, phone, email = line:match("([^,]+),([^,]+),([^,]+),([^,]+)")
        table.insert(contacts, { name = name, birthday = birthday, phone = phone, email = email })
    end
    file:close()
    return contacts
end

return FileManager
