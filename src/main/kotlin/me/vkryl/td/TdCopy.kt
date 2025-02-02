/*
 * This file is a part of tdlib-utils
 * Copyright © Vyacheslav Krylov (slavone@protonmail.ch) 2014-2022
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

@file:JvmName("Td")
@file:JvmMultifileClass

package me.vkryl.td

import org.drinkless.td.libcore.telegram.TdApi.*

fun ChatPermissions.copyTo (dst: ChatPermissions) {
  dst.canSendMessages = this.canSendMessages
  dst.canSendMediaMessages = this.canSendMediaMessages
  dst.canSendOtherMessages = this.canSendOtherMessages
  dst.canAddWebPagePreviews = this.canAddWebPagePreviews
  dst.canSendPolls = this.canSendPolls
  dst.canInviteUsers = this.canInviteUsers
  dst.canPinMessages = this.canPinMessages
  dst.canChangeInfo = this.canChangeInfo
}

fun ChatPosition.copyTo (dst: ChatPosition) {
  dst.list = this.list
  dst.order = this.order
  dst.isPinned = this.isPinned
  dst.source = this.source
}

fun File.copyTo (dst: File): Boolean {
  val hasChanges = !this.equalsTo(dst, false)

  dst.local.downloadedSize = this.local.downloadedSize
  dst.local.downloadOffset = this.local.downloadOffset
  dst.local.downloadedPrefixSize = this.local.downloadedPrefixSize
  dst.local.isDownloadingActive = this.local.isDownloadingActive
  dst.local.isDownloadingCompleted = this.local.isDownloadingCompleted
  dst.local.canBeDeleted = this.local.canBeDeleted
  dst.local.canBeDownloaded = this.local.canBeDownloaded
  dst.local.path = this.local.path

  dst.remote.uploadedSize = this.remote.uploadedSize
  dst.remote.isUploadingActive = this.remote.isUploadingActive
  dst.remote.isUploadingCompleted = this.remote.isUploadingCompleted
  dst.remote.uniqueId = this.remote.uniqueId
  dst.remote.id = this.remote.id

  dst.expectedSize = this.expectedSize
  dst.size = this.size

  return hasChanges
}

fun User.copyTo (dst: User) {
  dst.firstName = this.firstName
  dst.lastName = this.lastName
  dst.username = this.username
  dst.phoneNumber = this.phoneNumber
  dst.profilePhoto = this.profilePhoto
  dst.isContact = this.isContact
  dst.isMutualContact = this.isMutualContact
  dst.isVerified = this.isVerified
  dst.restrictionReason = this.restrictionReason
  dst.haveAccess = this.haveAccess
  dst.type = this.type
  dst.languageCode = this.languageCode
  dst.isPremium = this.isPremium
  dst.addedToAttachmentMenu = this.addedToAttachmentMenu
}

fun Message.copyTo (dst: Message) {
  dst.id = this.id
  dst.senderId = this.senderId
  dst.chatId = this.chatId
  dst.sendingState = this.sendingState
  dst.schedulingState = this.schedulingState
  dst.isOutgoing = this.isOutgoing
  dst.isPinned = this.isPinned
  dst.canBeEdited = this.canBeEdited
  dst.canBeForwarded = this.canBeForwarded
  dst.canBeSaved = this.canBeSaved
  dst.canBeDeletedOnlyForSelf = this.canBeDeletedOnlyForSelf
  dst.canBeDeletedForAllUsers = this.canBeDeletedForAllUsers
  dst.canGetAddedReactions = this.canGetAddedReactions
  dst.canGetStatistics = this.canGetStatistics
  dst.canGetMessageThread = this.canGetMessageThread
  dst.canGetViewers = this.canGetViewers
  dst.canGetMediaTimestampLinks = this.canGetMediaTimestampLinks
  dst.hasTimestampedMedia = this.hasTimestampedMedia
  dst.isChannelPost = this.isChannelPost
  dst.containsUnreadMention = this.containsUnreadMention
  dst.date = this.date
  dst.editDate = this.editDate
  dst.forwardInfo = this.forwardInfo
  dst.interactionInfo = this.interactionInfo
  dst.unreadReactions = this.unreadReactions
  dst.replyInChatId = this.replyInChatId
  dst.replyToMessageId = this.replyToMessageId
  dst.messageThreadId = this.messageThreadId
  dst.ttl = this.ttl
  dst.ttlExpiresIn = this.ttlExpiresIn
  dst.viaBotUserId = this.viaBotUserId
  dst.authorSignature = this.authorSignature
  dst.mediaAlbumId = this.mediaAlbumId
  dst.restrictionReason = this.restrictionReason
  dst.content = this.content
  dst.replyMarkup = this.replyMarkup
}

fun File?.copyOf (): File? {
  return this?.let {
    File(
      this.id,
      this.size,
      this.expectedSize,
      this.local.copyOf(),
      this.remote.copyOf())
  }
}

fun LocalFile?.copyOf (): LocalFile? {
  return this?.let {
    LocalFile(
      this.path,
      this.canBeDownloaded,
      this.canBeDeleted,
      this.isDownloadingActive,
      this.isDownloadingCompleted,
      this.downloadOffset,
      this.downloadedPrefixSize,
      this.downloadedSize
    )
  }
}

fun RemoteFile?.copyOf (): RemoteFile? {
  return this?.let {
    RemoteFile(
      this.id,
      this.uniqueId,
      this.isUploadingActive,
      this.isUploadingCompleted,
      this.uploadedSize
    )
  }
}

fun Message?.copyOf (): Message? {
  return this?.let {
    Message(
      this.id,
      this.senderId,
      this.chatId,
      this.sendingState,
      this.schedulingState,
      this.isOutgoing,
      this.isPinned,
      this.canBeEdited,
      this.canBeForwarded,
      this.canBeSaved,
      this.canBeDeletedOnlyForSelf,
      this.canBeDeletedForAllUsers,
      this.canGetAddedReactions,
      this.canGetStatistics,
      this.canGetMessageThread,
      this.canGetViewers,
      this.canGetMediaTimestampLinks,
      this.hasTimestampedMedia,
      this.isChannelPost,
      this.containsUnreadMention,
      this.date,
      this.editDate,
      this.forwardInfo,
      this.interactionInfo,
      this.unreadReactions,
      this.replyInChatId,
      this.replyToMessageId,
      this.messageThreadId,
      this.ttl,
      this.ttlExpiresIn,
      this.viaBotUserId,
      this.authorSignature,
      this.mediaAlbumId,
      this.restrictionReason,
      this.content,
      this.replyMarkup
    )
  }
}

fun Chat?.copyOf (): Chat? {
  return this?.let {
    Chat(
      this.id,
      this.type,
      this.title,
      this.photo,
      this.permissions,
      this.lastMessage,
      if (this.positions != null) this.positions.copyOf() else null,
      this.messageSenderId,
      this.hasProtectedContent,
      this.isMarkedAsUnread,
      this.isBlocked,
      this.hasScheduledMessages,
      this.canBeDeletedOnlyForSelf,
      this.canBeDeletedForAllUsers,
      this.canBeReported,
      this.defaultDisableNotification,
      this.unreadCount,
      this.lastReadInboxMessageId,
      this.lastReadOutboxMessageId,
      this.unreadMentionCount,
      this.unreadReactionCount,
      this.notificationSettings,
      this.availableReactions,
      this.messageTtl,
      this.themeName,
      this.actionBar,
      this.videoChat,
      this.pendingJoinRequests,
      this.replyMarkupMessageId,
      this.draftMessage,
      this.clientData
    )
  }
}

fun ChatPermissions?.copyOf (): ChatPermissions? {
  return this?.let {
    ChatPermissions(
      this.canSendMessages,
      this.canSendMediaMessages,
      this.canSendPolls,
      this.canSendOtherMessages,
      this.canAddWebPagePreviews,
      this.canChangeInfo,
      this.canInviteUsers,
      this.canPinMessages
    )
  }
}

fun StickerSetInfo?.copyOf (): StickerSetInfo? {
  return this?.let {
    StickerSetInfo(
      this.id,
      this.title,
      this.name,
      this.thumbnail,
      this.thumbnailOutline,
      this.isInstalled,
      this.isArchived,
      this.isOfficial,
      this.stickerFormat,
      this.stickerType,
      this.isViewed,
      this.size,
      this.covers
    )
  }
}

fun StickerSet?.copyOf (): StickerSet? {
  return this?.let {
    StickerSet(
      this.id,
      this.title,
      this.name,
      this.thumbnail,
      this.thumbnailOutline,
      this.isInstalled,
      this.isArchived,
      this.isOfficial,
      this.stickerFormat,
      this.stickerType,
      this.isViewed,
      this.stickers,
      this.emojis
    )
  }
}

fun ChatAdministratorRights?.copyOf (): ChatAdministratorRights? {
  return this?.let {
    ChatAdministratorRights(
      this.canManageChat,
      this.canChangeInfo,
      this.canPostMessages,
      this.canEditMessages,
      this.canDeleteMessages,
      this.canInviteUsers,
      this.canRestrictMembers,
      this.canPinMessages,
      this.canPromoteMembers,
      this.canManageVideoChats,
      this.isAnonymous
    )
  }
}

fun ChatMemberStatus?.copyOf (): ChatMemberStatus? {
  return this?.let {
    when (constructor) {
      ChatMemberStatusCreator.CONSTRUCTOR -> ChatMemberStatusCreator(
        (this as ChatMemberStatusCreator).customTitle,
        this.isAnonymous,
        this.isMember
      )
      ChatMemberStatusAdministrator.CONSTRUCTOR -> ChatMemberStatusAdministrator(
        (this as ChatMemberStatusAdministrator).customTitle,
        this.canBeEdited,
        this.rights.copyOf()
      )
      ChatMemberStatusBanned.CONSTRUCTOR -> ChatMemberStatusBanned((this as ChatMemberStatusBanned).bannedUntilDate)
      ChatMemberStatusLeft.CONSTRUCTOR -> ChatMemberStatusLeft()
      ChatMemberStatusMember.CONSTRUCTOR -> ChatMemberStatusMember()
      ChatMemberStatusRestricted.CONSTRUCTOR -> ChatMemberStatusRestricted(
        (this as ChatMemberStatusRestricted).isMember,
        this.restrictedUntilDate,
        this.permissions.copyOf()
      )
      else -> TODO(this.toString())
    }
  }
}