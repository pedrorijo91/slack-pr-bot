# slack-pr-bot

[![Codacy Badge](https://api.codacy.com/project/badge/ce7e7c4216fd425ebdbff658dca70b34)](https://www.codacy.com)
[![Build Status](https://travis-ci.org/pedrorijo91/slack-pr-bot.svg?branch=master)](https://travis-ci.org/pedrorijo91/slack-pr-bot)

[Slack bot](https://api.slack.com/bot-users) that reminds team members to review existing pull requests in regular time intervals.

Built with [gilbertw1/slack-scala-client](https://github.com/gilbertw1/slack-scala-client) library.

## How to run
Simply click on the "Deploy to Heroku" button under this section, or use the command `sbt run`.

[![Deploy](https://www.herokucdn.com/deploy/button.png)](https://heroku.com/deploy)

### Requirements
In the `src/main/resources/application.conf` file you need to insert the `Slack API Token` in the `slack.token` field, and the `room id` in the `slack.room` field.

The documentation is available [online](https://api.slack.com/bot-users)

> Note: You need to manually create the bot user [here](https://my.slack.com/services/new/bot) and enable it.
Also, you need to invite the bot to the channel/group since it can't join channels/groups by itself

### Configuration

The bot allows to easily configure some parameters:

* **Time interval** between each reminder, through the `slack.interval`parameter
* **Message** posted by the bot, through the `slack.message`parameter
* **Mentioning** all channel/group users or not, through the `slack.mention`parameter

# Other usages

This bot can easily be generalized for any other regular task replacing the body of the `postMessage` method
