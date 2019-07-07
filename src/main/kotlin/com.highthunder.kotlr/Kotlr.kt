package com.highthunder.kotlr

import com.highthunder.kotlr.json.qualifier.HexColorJsonAdapter
import com.highthunder.kotlr.json.qualifier.HexColorOctothorpeJsonAdapter
import com.highthunder.kotlr.json.response.blog.BlogAvatarWrapperJsonAdapter
import com.highthunder.kotlr.json.response.blog.BlogDraftsWrapperJsonAdapter
import com.highthunder.kotlr.json.response.blog.BlogFollowersWrapperJsonAdapter
import com.highthunder.kotlr.json.response.blog.BlogFollowingWrapperJsonAdapter
import com.highthunder.kotlr.json.response.blog.BlogInfoWrapperJsonAdapter
import com.highthunder.kotlr.json.response.blog.BlogLikesWrapperJsonAdapter
import com.highthunder.kotlr.json.response.blog.BlogPostsWrapperJsonAdapter
import com.highthunder.kotlr.json.response.blog.BlogQueueWrapperJsonAdapter
import com.highthunder.kotlr.json.response.blog.BlogSubmissionsWrapperJsonAdapter
import com.highthunder.kotlr.json.response.user.UserDashboardWrapperJsonAdapter
import com.highthunder.kotlr.json.response.user.UserFollowingWrapperJsonAdapter
import com.highthunder.kotlr.json.response.user.UserInfoWrapperJsonAdapter
import com.highthunder.kotlr.json.response.user.UserLikesWrapperJsonAdapter
import com.highthunder.kotlr.json.wrapper.ColorsJsonAdapter
import com.highthunder.kotlr.json.wrapper.ContentWrapperJsonAdapter
import com.highthunder.kotlr.json.wrapper.MediaWrapperJsonAdapter
import com.highthunder.kotlr.json.wrapper.PlayerWrapperJsonAdapter
import com.highthunder.kotlr.json.wrapper.ThemeWrapperJsonAdapter
import com.highthunder.kotlr.json.wrapper.UserJsonAdapter
import com.highthunder.kotlr.json.wrapper.VideoJsonAdapter
import com.highthunder.kotlr.types.BlockPost
import com.highthunder.kotlr.types.NoteData
import com.highthunder.kotlr.types.Post
import com.highthunder.kotlr.types.content.Attribution
import com.highthunder.kotlr.types.content.BlockLayout
import com.highthunder.kotlr.types.content.PostContent
import com.highthunder.kotlr.types.content.TextFormat
import com.highthunder.kotlr.types.legacy.AnswerPost
import com.highthunder.kotlr.types.legacy.AudioPost
import com.highthunder.kotlr.types.legacy.ChatPost
import com.highthunder.kotlr.types.legacy.LinkPost
import com.highthunder.kotlr.types.legacy.PhotoPost
import com.highthunder.kotlr.types.legacy.QuotePost
import com.highthunder.kotlr.types.legacy.TextPost
import com.highthunder.kotlr.types.legacy.VideoPost
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory

/**
 * Get an instance of the Moshi JSON parser that is setup to parse all of our data types.
 *
 * This is broken up into four steps because some adapters depend on the existence of
 * other adapters.
 */
internal val moshi: Moshi by lazy {
    val attributionAdapterFactory: PolymorphicJsonAdapterFactory<Attribution> = PolymorphicJsonAdapterFactory
        .of(Attribution::class.java, "type")
        .withSubtype(Attribution.Post::class.java, Attribution.Post.KEY)
        .withSubtype(Attribution.Link::class.java, Attribution.Link.KEY)
        .withSubtype(Attribution.Blog::class.java, Attribution.Blog.KEY)
        .withSubtype(Attribution.App::class.java, Attribution.App.KEY)

    val blockLayoutAdapterFactory = PolymorphicJsonAdapterFactory
        .of(BlockLayout::class.java, "type")
        .withSubtype(BlockLayout.Ask::class.java, BlockLayout.Ask.KEY)
        .withSubtype(BlockLayout.Condensed::class.java, BlockLayout.Condensed.KEY)
        .withSubtype(BlockLayout.Row::class.java, BlockLayout.Row.KEY)
        .withSubtype(BlockLayout.Vertical::class.java, BlockLayout.Vertical.KEY)

    val contentAdapterFactory = PolymorphicJsonAdapterFactory
        .of(PostContent::class.java, "type")
        .withSubtype(PostContent.AudioContent::class.java, PostContent.AudioContent.KEY)
        .withSubtype(PostContent.ImageContent::class.java, PostContent.ImageContent.KEY)
        .withSubtype(PostContent.LinkContent::class.java, PostContent.LinkContent.KEY)
        .withSubtype(PostContent.TextContent::class.java, PostContent.TextContent.KEY)
        .withSubtype(PostContent.VideoContent::class.java, PostContent.VideoContent.KEY)

    val displayModeAdapterFactory = PolymorphicJsonAdapterFactory
        .of(BlockLayout.Row.Display.Mode::class.java, "type")
        .withSubtype(BlockLayout.Row.Display.Mode.Weighted::class.java, BlockLayout.Row.Display.Mode.Weighted.KEY)
        .withSubtype(BlockLayout.Row.Display.Mode.Carousel::class.java, BlockLayout.Row.Display.Mode.Carousel.KEY)

    val noteDataAdapterFactory = PolymorphicJsonAdapterFactory
        .of(NoteData::class.java, "type")
        .withSubtype(NoteData.Attribution::class.java, NoteData.Attribution.KEY)
        .withSubtype(NoteData.Like::class.java, NoteData.Like.KEY)
        .withSubtype(NoteData.Posted::class.java, NoteData.Posted.KEY)
        .withSubtype(NoteData.Reblog::class.java, NoteData.Reblog.KEY)
        .withSubtype(NoteData.Reply::class.java, NoteData.Reply.KEY)

    val postAdapterFactory = PolymorphicJsonAdapterFactory
        .of(Post::class.java, "type")
        .withSubtype(AnswerPost::class.java, Post.Type.Answer.key)
        .withSubtype(AudioPost::class.java, Post.Type.Audio.key)
        .withSubtype(ChatPost::class.java, Post.Type.Chat.key)
        .withSubtype(LinkPost::class.java, Post.Type.Link.key)
        .withSubtype(PhotoPost::class.java, Post.Type.Photo.key)
        .withSubtype(QuotePost::class.java, Post.Type.Quote.key)
        .withSubtype(TextPost::class.java, Post.Type.Text.key)
        .withSubtype(VideoPost::class.java, Post.Type.Video.key)
        .withSubtype(BlockPost::class.java, Post.Type.Blocks.key)

    val textFormatAdapterFactory = PolymorphicJsonAdapterFactory
        .of(TextFormat::class.java, "type")
        .withSubtype(TextFormat.Bold::class.java, TextFormat.Bold.KEY)
        .withSubtype(TextFormat.Color::class.java, TextFormat.Color.KEY)
        .withSubtype(TextFormat.Italic::class.java, TextFormat.Italic.KEY)
        .withSubtype(TextFormat.Link::class.java, TextFormat.Link.KEY)
        .withSubtype(TextFormat.Mention::class.java, TextFormat.Mention.KEY)
        .withSubtype(TextFormat.Size::class.java, TextFormat.Size.KEY)
        .withSubtype(TextFormat.StrikeThrough::class.java, TextFormat.StrikeThrough.KEY)

    val step1: Moshi = Moshi
        .Builder()
        .add(attributionAdapterFactory)
        .add(blockLayoutAdapterFactory)
        .add(contentAdapterFactory)
        .add(displayModeAdapterFactory)
        .add(noteDataAdapterFactory)
        .add(textFormatAdapterFactory)
        .add(HexColorJsonAdapter())
        .add(HexColorOctothorpeJsonAdapter())
        .build()
    val step2: Moshi = step1
        .newBuilder()
        .add(ColorsJsonAdapter(step1))
        .add(VideoJsonAdapter(step1))
        .add(UserJsonAdapter(step1))
        .build()
    val step3: Moshi = step2
        .newBuilder()
        .add(postAdapterFactory)
        .add(MediaWrapperJsonAdapter(step2))
        .add(ThemeWrapperJsonAdapter(step2))
        .add(PlayerWrapperJsonAdapter(step2))
        .add(ContentWrapperJsonAdapter(step2))
        .build()
    return@lazy step3.newBuilder()
        .add(BlogAvatarWrapperJsonAdapter(step3))
        .add(BlogDraftsWrapperJsonAdapter(step3))
        .add(BlogFollowersWrapperJsonAdapter(step3))
        .add(BlogFollowingWrapperJsonAdapter(step3))
        .add(BlogInfoWrapperJsonAdapter(step3))
        .add(BlogLikesWrapperJsonAdapter(step3))
        .add(BlogPostsWrapperJsonAdapter(step3))
        .add(BlogQueueWrapperJsonAdapter(step3))
        .add(BlogSubmissionsWrapperJsonAdapter(step3))
        .add(UserInfoWrapperJsonAdapter(step3))
        .add(UserDashboardWrapperJsonAdapter(step3))
        .add(UserLikesWrapperJsonAdapter(step3))
        .add(UserFollowingWrapperJsonAdapter(step3))
        .build()
}
