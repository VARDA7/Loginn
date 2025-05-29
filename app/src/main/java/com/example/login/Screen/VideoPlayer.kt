package com.example.login.Screen

import android.content.Context
import android.net.Uri
import android.view.ViewOutlineProvider
import androidx.annotation.OptIn
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView



@OptIn(UnstableApi::class)
@Composable
fun VideoPlayer(context: Context, videoUri: Uri, modifier: Modifier = Modifier) {
    val exoPlayer = remember(context) {
        ExoPlayer.Builder(context).build().apply {
            setMediaItem(MediaItem.fromUri(videoUri))
            prepare()
            playWhenReady = true
            repeatMode = Player.REPEAT_MODE_ALL
        }
    }


    Box(
        modifier = modifier
            .clip(RoundedCornerShape(24.dp))
    ) {

        AndroidView(
            factory = {
                PlayerView(it).apply {
                    player = exoPlayer
                    useController = false
                    setBackgroundColor(android.graphics.Color.TRANSPARENT)
                    setShutterBackgroundColor(android.graphics.Color.TRANSPARENT)


                    outlineProvider = ViewOutlineProvider.BACKGROUND
                    clipToOutline = true
                }
            },
            modifier = Modifier.fillMaxSize()
        )
    }
}

