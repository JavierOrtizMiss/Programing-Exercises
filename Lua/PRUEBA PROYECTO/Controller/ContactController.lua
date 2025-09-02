local ContactController = {}
local Contact = require("Model.Contact")

function ContactController:new()
    local obj = { contacts = {} }
    setmetatable(obj, self)
    self.__index = self
    return obj
end

local function isValidBirthday(birthday)
    return birthday:match("^%d%d/%d%d$") ~= nil
end

function ContactController:addContact(name, birthday, phone, email)
    if not isValidBirthday(birthday) then
        return false, "El cumpleaños debe tener el formato dd/mm."
    end
    local contact = Contact:new(name, email, phone, birthday)
    table.insert(self.contacts, contact)
    return true
end

function ContactController:getContactByName(name)
    for _, contact in ipairs(self.contacts) do
        if contact.name == name then
            return contact
        end
    end
    return nil, "Contacto no encontrado."
end

function ContactController:getContactsByMonth(month)
    local result = {}
    for _, contact in ipairs(self.contacts) do
        if contact.birthday_date:sub(4, 5) == month then
            table.insert(result, contact)
        end
    end
    return result
end

function ContactController:getAllContacts()
    table.sort(self.contacts, function(a, b) return a.name < b.name end)
    return self.contacts
end

function ContactController:updateContact(name, new_name, new_email, new_phone, new_birthday_date)
    local contact, message = self:getContactByName(name)
    if not contact then
        return false, message
    end
    if new_birthday_date and not isValidBirthday(new_birthday_date) then
        return false, "El cumpleaños debe tener el formato dd/mm."
    end
    if new_name then contact:change_name(new_name) end
    if new_email then contact:change_email(new_email) end
    if new_phone then contact:change_phone(new_phone) end
    if new_birthday_date then contact:change_birthday_date(new_birthday_date) end
    return true
end

return ContactController
