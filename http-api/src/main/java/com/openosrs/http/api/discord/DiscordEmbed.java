/*
 * Copyright (c) 2018, Forsco <https://github.com/forsco>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.openosrs.http.api.discord;

import com.openosrs.http.api.discord.embed.AuthorEmbed;
import com.openosrs.http.api.discord.embed.FieldEmbed;
import com.openosrs.http.api.discord.embed.FooterEmbed;
import com.openosrs.http.api.discord.embed.ImageEmbed;
import com.openosrs.http.api.discord.embed.ProviderEmbed;
import com.openosrs.http.api.discord.embed.ThumbnailEmbed;
import com.openosrs.http.api.discord.embed.VideoEmbed;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class DiscordEmbed
{
	String title;
	String type;
	String description;
	String url;
	String timestamp;
	String iconurl;
	String color;
	FooterEmbed footer;
	ImageEmbed image;
	ThumbnailEmbed thumbnail;
	VideoEmbed video;
	ProviderEmbed provider;
	AuthorEmbed author;
	@Singular
	List<FieldEmbed> fields = new ArrayList<>();

	public DiscordEmbed(AuthorEmbed author, ThumbnailEmbed thumb, String description, FooterEmbed footer, String color, List<FieldEmbed> fields)
	{
		this.author = author;
		this.thumbnail = thumb;
		this.description = description;
		this.footer = footer;
		this.color = color;
		this.fields.addAll(fields);
	}

	public DiscordMessage toDiscordMessage(String username, String content, String avatarUrl)
	{
		return toDiscordMessage(username, content, avatarUrl, false);
	}

	public DiscordMessage toDiscordMessage(String username, String content, String avatarUrl, boolean textToSpeech)
	{
		return new DiscordMessage(username, content, avatarUrl, textToSpeech, Collections.singletonList(this));
	}
}
