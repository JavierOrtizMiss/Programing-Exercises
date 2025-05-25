local gui = require("gui") -- Assuming a GUI library is available
local controller = require("controller") -- Controller to handle logic

local AddContactView = require("view.AddContactView")
local SearchContactView = require("view.SearchContactView")
local ListContactsView = require("view.ListContactsView")

-- Initialize GUI
local app = gui.newApp("Contact Manager")

-- Render Views
local addContactView = AddContactView:new(app, controller)
addContactView:render()

local searchContactView = SearchContactView:new(app, controller)
searchContactView:render()

local listContactsView = ListContactsView:new(app, controller)
listContactsView:render()

-- Run the application
app:run()