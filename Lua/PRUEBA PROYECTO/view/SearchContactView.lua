local SearchContactView = {}
SearchContactView.__index = SearchContactView

function SearchContactView:new(app, controller)
    local self = setmetatable({}, SearchContactView)
    self.app = app
    self.controller = controller
    return self
end

function SearchContactView:render()
    self.app:addLabel("Search Contact")
    self.app:addTextField("SearchName", "Enter name to search")
    self.app:addButton("Search", function()
        local name = self.app:getTextField("SearchName")
        local contact = self.controller:getContactByName(name)
        if contact then
            self.app:showMessage("Contact Found", string.format("Name: %s\nBirthday: %s\nPhone: %s\nEmail: %s", contact.name, contact.birthday, contact.phone, contact.email))
        else
            self.app:showMessage("Error", "Contact not found")
        end
    end)
end

return SearchContactView
