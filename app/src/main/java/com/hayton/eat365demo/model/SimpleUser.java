package com.hayton.eat365demo.model;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.net.URI;

public class SimpleUser {

    @SerializedName("name")
    private String name;

    @SerializedName("email")
    private String email;

    @SerializedName("login")
    private String login;

    @SerializedName("id")
    private Long id;

    @SerializedName("node_id")
    private String nodeId;

    @SerializedName("avatar_url")
    private URI avatarUrl;

    @SerializedName("gravatar_id")
    private String gravatarId;

    @SerializedName("url")
    private URI url;

    @SerializedName("html_url")
    private URI htmlUrl;

    @SerializedName("followers_url")
    private URI followersUrl;

    @SerializedName("following_url")
    private String followingUrl;

    @SerializedName("gists_url")
    private String gistsUrl;

    @SerializedName("starred_url")
    private String starredUrl;

    @SerializedName("subscriptions_url")
    private URI subscriptionsUrl;

    @SerializedName("organizations_url")
    private URI organizationsUrl;

    @SerializedName("repos_url")
    private URI reposUrl;

    @SerializedName("events_url")
    private String eventsUrl;

    @SerializedName("received_events_url")
    private URI receivedEventsUrl;

    @SerializedName("type")
    private String type;

    @SerializedName("site_admin")
    private Boolean siteAdmin;

    @SerializedName("starred_at")
    private String starredAt;

    @SerializedName("user_view_type")
    private String userViewType;

    // Getters and setters

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNodeId() { return nodeId; }
    public void setNodeId(String nodeId) { this.nodeId = nodeId; }

    public URI getAvatarUrl() { return avatarUrl; }
    public void setAvatarUrl(URI avatarUrl) { this.avatarUrl = avatarUrl; }

    public String getGravatarId() { return gravatarId; }
    public void setGravatarId(String gravatarId) { this.gravatarId = gravatarId; }

    public URI getUrl() { return url; }
    public void setUrl(URI url) { this.url = url; }

    public URI getHtmlUrl() { return htmlUrl; }
    public void setHtmlUrl(URI htmlUrl) { this.htmlUrl = htmlUrl; }

    public URI getFollowersUrl() { return followersUrl; }
    public void setFollowersUrl(URI followersUrl) { this.followersUrl = followersUrl; }

    public String getFollowingUrl() { return followingUrl; }
    public void setFollowingUrl(String followingUrl) { this.followingUrl = followingUrl; }

    public String getGistsUrl() { return gistsUrl; }
    public void setGistsUrl(String gistsUrl) { this.gistsUrl = gistsUrl; }

    public String getStarredUrl() { return starredUrl; }
    public void setStarredUrl(String starredUrl) { this.starredUrl = starredUrl; }

    public URI getSubscriptionsUrl() { return subscriptionsUrl; }
    public void setSubscriptionsUrl(URI subscriptionsUrl) { this.subscriptionsUrl = subscriptionsUrl; }

    public URI getOrganizationsUrl() { return organizationsUrl; }
    public void setOrganizationsUrl(URI organizationsUrl) { this.organizationsUrl = organizationsUrl; }

    public URI getReposUrl() { return reposUrl; }
    public void setReposUrl(URI reposUrl) { this.reposUrl = reposUrl; }

    public String getEventsUrl() { return eventsUrl; }
    public void setEventsUrl(String eventsUrl) { this.eventsUrl = eventsUrl; }

    public URI getReceivedEventsUrl() { return receivedEventsUrl; }
    public void setReceivedEventsUrl(URI receivedEventsUrl) { this.receivedEventsUrl = receivedEventsUrl; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public Boolean getSiteAdmin() { return siteAdmin; }
    public void setSiteAdmin(Boolean siteAdmin) { this.siteAdmin = siteAdmin; }

    public String getStarredAt() { return starredAt; }
    public void setStarredAt(String starredAt) { this.starredAt = starredAt; }

    public String getUserViewType() { return userViewType; }
    public void setUserViewType(String userViewType) { this.userViewType = userViewType; }

    @Override
    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SimpleUser)) {
            return false;
        }
        return this.siteAdmin == ((SimpleUser) obj).siteAdmin &&
                this.login.equals(((SimpleUser) obj).login) &&
                this.id.equals(((SimpleUser) obj).id) &&
                this.nodeId.equals(((SimpleUser) obj).nodeId) &&
                this.avatarUrl.equals(((SimpleUser) obj).avatarUrl) &&
                this.url.equals(((SimpleUser) obj).url) &&
                this.htmlUrl.equals(((SimpleUser) obj).htmlUrl) &&
                this.followersUrl.equals(((SimpleUser) obj).followersUrl) &&
                this.followingUrl.equals(((SimpleUser) obj).followingUrl) &&
                this.gistsUrl.equals(((SimpleUser) obj).gistsUrl) &&
                this.starredUrl.equals(((SimpleUser) obj).starredUrl) &&
                this.subscriptionsUrl.equals(((SimpleUser) obj).subscriptionsUrl) &&
                this.organizationsUrl.equals(((SimpleUser) obj).organizationsUrl) &&
                this.reposUrl.equals(((SimpleUser) obj).reposUrl) &&
                this.eventsUrl.equals(((SimpleUser) obj).eventsUrl) &&
                this.receivedEventsUrl.equals(((SimpleUser) obj).receivedEventsUrl) &&
                this.type.equals(((SimpleUser) obj).type);
    }
}
