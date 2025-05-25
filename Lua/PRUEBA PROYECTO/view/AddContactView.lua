local AddContactView = {}
AddContactView.__index = AddContactView

function AddContactView:new(app, controller)
    local self = setmetatable({}, AddContactView)
    self.app = app
    self.controller = controller
    return self
end

function AddContactView:render()
    self.app:addLabel("Add Contact")
    self.app:addTextField("Name", "Enter name")
    self.app:addTextField("Birthday", "Enter birthday (dd/mm)")
    self.app:addTextField("Phone", "Enter phone")
    self.app:addTextField("Email", "Enter email")
    self.app:addButton("Add Contact", function()
        local name = self.app:getTextField("Name")
        local birthday = self.app:getTextField("Birthday")
        local phone = self.app:getTextField("Phone")
        local email = self.app:getTextField("Email")
        self.controller:addContact(name, birthday, phone, email)
    end)
end

return AddContactView
