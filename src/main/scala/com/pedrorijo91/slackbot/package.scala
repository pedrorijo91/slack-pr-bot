package com.pedrorijo91

import com.typesafe.config.{ConfigFactory, Config}

package object slackbot {

  private val conf: Config = ConfigFactory.load

  private val TokenConfigPath = "slack.token"
  private val RoomConfigPath = "slack.room"
  private val MessageConfigPath = "slack.message"
  private val IntervalConfigPath = "slack.interval"
  private val MentionConfigPath = "slack.mention"

  private val DefaultMessage: String = "Guys, please review pending pull requests !"
  private val DefaultInterval: Long = 1000 * 60 * 60 * 8// 1000 milliseconds * 60 * 60 * 8 = 8 hours
  private val DefaultMentionAll: Boolean = true

  def getToken: String = {
    conf.getString(TokenConfigPath)
  }

  def getRoom: String = {
    conf.getString(RoomConfigPath)
  }

  def getMessage: String = {
    if(conf.hasPath(MessageConfigPath)) conf.getString(MessageConfigPath) else DefaultMessage
  }

  def getInterval: Long = {
    if(conf.hasPath(IntervalConfigPath)) conf.getLong(IntervalConfigPath) else DefaultInterval
  }

  def getMentionAll: Boolean = {
    if(conf.hasPath(MentionConfigPath)) conf.getBoolean(MentionConfigPath) else DefaultMentionAll
  }
}
