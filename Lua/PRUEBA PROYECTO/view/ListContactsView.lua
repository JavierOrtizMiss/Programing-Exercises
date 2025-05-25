local ListContactsView = {}
ListContactsView.__index = ListContactsView

function ListContactsView:new(app, controller)
    local self = setmetatable({}, ListContactsView)
    self.app = app
    self.controller = controller
    return self
end

function ListContactsView:render()
    self.app:addLabel("List Contacts by Month")
    self.app:addTextField("Month", "Enter month (1-12)")
    self.app:addButton("List", function()
        local month = tonumber(self.app:getTextField("Month"))
        local contacts = self.controller:getContactsByMonth(month)
        local message = "Contacts with birthdays in month " .. month .. ":\n"
        for _, contact in ipairs(contacts) do
            message = message .. string.format("Name: %s, Birthday: %s, Phone: %s, Email: %s\n", contact.name, contact.birthday, contact.phone, contact.email)
        end
        self.app:showMessage("Contacts", message)
    end)

    self.app:addButton("List All Contacts", function()
        local contacts = self.controller:getAllContactsSorted()
        local message = "All Contacts:\n"
        for _, contact in ipairs(contacts) do
            message = message .. string.format("Name: %s, Birthday: %s, Phone: %s, Email: %s\n", contact.name, contact.birthday, contact.phone, contact.email)
        end
        self.app:showMessage("Contacts", message)
    end)
end

return ListContactsView
