package com.pedrorijo91.slackbot

import org.slf4j.LoggerFactory
import scala.annotation.tailrec
import scala.concurrent.ExecutionContext.Implicits.global
import slack.api.BlockingSlackApiClient

object SlackBot {

  val logger = LoggerFactory.getLogger(SlackBot.getClass)

  def main(args: Array[String]): Unit = {

    val token = getToken
    val roomId = getRoom
    val message = getMessage
    val interval = getInterval
    val mentionAll = getMentionAll

    logger.info(s"Configuration read - token: $token, room: $roomId, interval (milliseconds): $interval, mentionAll: $mentionAll, message: $message")

    val client = BlockingSlackApiClient(token)
    postMessage(client, roomId, message, interval, mentionAll)

  }

  @tailrec
  def postMessage(client: BlockingSlackApiClient, roomId: String, message: String, interval: Long, mentionAll: Boolean): Unit = {
    val fullMessage = if(mentionAll) s"<!channel> $message" else message
    val response = client.postChatMessage(roomId, fullMessage)
    logger.info(s"slack response: $response")

    logger.info(s"Going for sleep for $interval milliseconds")
    Thread.sleep(interval)
    logger.info(s"waking up")

    postMessage(client, roomId, message, interval, mentionAll)
  }
}
