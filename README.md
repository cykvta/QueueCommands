# QueueCommands
QueueCommands is a simple Spigot plugin that allows you to leave pending commands for users on your server.
These commands are executed only by the console.

## Features
- **Add Commands to Queue**: Allows you to queue commands for users.
- **Customizable Check Interval**: Server checks the queue every x time (configurable in the new version).

## Permissions and Commands
- /qc add
  - usage: `/qc add <username> <command without "/"..>`
  - permission: `qc.add`
  - description: Adds a command to the queue for the specified user.

## Usage
To add a command to the queue, use the following command:
`/qc add <username> <command without "/"..>`
Replace `<username>` with the target player's username and `<command without "/"..>` with the command you want to queue (without the leading `/`).

## Configuration Options
- **Queue Check Interval**: Configure how often the server checks the queue in the `config.yml` file. You can set this to check every minute if needed.

## Installation
1. Download the latest version of QueueCommands.
2. Place the `.jar` file in your server's `plugins` directory.
3. Restart your server.

## Support

If you have any issues or questions, please open an issue on the plugin's GitHub repository.