AdvancedEco is a lightweight plugin for server owners who don't want a large, complicated, economy plugin. This plugin works much like any other economy management plugin. Server owners who prefer their players to start off with $0.0 balance can configure the options to reward them with money for killing a mob, drop more XP, or in the next update be able to join a job. Every minute that passes, this plugin becomes more advanced!

When this plugin started, it was technically under the management / original developer who goes by the name of DurzoBlint15 who I thank for giving me inspiration to update his outdated plugin. Now, it's become a bigger plugin with every update, so I've decided to change the name to AdvancedEco to make the name relative to it's growing contents.

I hope you find this plugin to be useful in your server's economy system, and please submit a ticket when you find an error!

As of the 1.4.7 update, you'll need to delete the old configuration from all previous versions. v0.5.6 will also need to be completely deleted, as it will have the new name, configuration and other additions. You can copy over the configuration manually when the update comes, and I promise it'll be the last of the massive configuration and name changes.

Features
- Tracks and logs player accounts
- Assigns new players that join a certain amount of money customizable in configuration
- Configuration files and player database
- Separate configuration files for each feature
- Users can pay each other money
- Users can give money (This does not release funds from an account, so recommended for admins only)
- Users can set players balance
- Users can reload the configuration from ingame or console
- Mob reward addon which can be enabled/disabled in the main configuration
- Can be stored flatfile, MySQL or SQLite (MySQL + SQLite will be added in v0.5.6)
- Compatible with almost all major permission management plugins
- Vault integration

Installation
1. Download Vault and place it in the plugin folder as you would install any plugin (Get Vault)
2. Give the desired groups permissions to AdvancedEco
3. Add AdvancedEco.jar to your plugin folder
4. Reload or restart your server
5. Open config.yml and edit the currency / starting money amount to your preference The mob rewards are turned off by default, if you turn it on in the configuration, the server will need to be restared or reloaded with /reload.
6. Reload your permission plugin
7. Type /money reload

Permissions
1. AdvancedEco.user : Players can use "/money" and "/money help."
2. AdvancedEco.pay : Players can use "/money pay."
3. AdvancedEco.give : Players can use "/money give."
4. AdvancedEco.set : Players can use "/money set."
5. AdvancedEco.reload : Players can use "/ae reload."

Commands
Note: You may use a short version of the player's name (I.E. Instead of "rjp2525" you can use "rjp"), however it is not recommended for accurate transfer.
1. /money pay (user) (amount) : Lets players pay (user) (amount).
2. /money give (user) (amount) : Lets players give someone else money(this money does not come out of an account).
3. /money set (user) (amount) : Lets players set someones account balance.
4. /money reload : Lets players reload the money config.
5. /money help : Lets players see helpful info.
6. /money : Lets players check their balance.

Mob Rewards
All mob rewards are set to 0.0 by default. If a reward is set to 0.0, no message will appear when someone kills a mob. You can configure a positive or negative reward in the prices.yml configuration file.

Future Additions
- Edit configuration using in-game commands [v0.6.0]
- Add MySQL / SQLite database options [v0.6.0]
- Add a simple jobs addon [v0.6.0]
- Add sign shop / command /sell <hand/inventory> <amount> [v0.6.0]
- Add mob exp drop customization [v0.5.6]
- Add MySQL / SQLite database options [v0.6.0]
