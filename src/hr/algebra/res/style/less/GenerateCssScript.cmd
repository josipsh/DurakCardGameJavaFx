@echo Off

echo generating commands started

lessc MainWindowStyle.less ..\MainWindowStyle.css &^
lessc SettingsWindowStyle.less ..\SettingsWindowStyle.css &^
lessc AlertStyle.less ..\AlertStyle.css &^
lessc MenuBarStyle.less ..\MenuBarStyle.css &^
lessc GameComponentStyle.less ..\GameComponentStyle.css &^
lessc ChatComponentStyle.less ..\ChatComponentStyle.css

pause
@echo On
