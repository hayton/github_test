package com.hayton.eat365demo.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Objects;

public class PublicUser implements Serializable {

    // Required
    @SerializedName("login")
    private String login;

    @SerializedName("id")
    private Long id;

    @SerializedName("user_view_type")
    private String userViewType;

    @SerializedName("node_id")
    private String nodeId;

    @SerializedName("avatar_url")
    private String avatarUrl;

    @SerializedName("gravatar_id")
    private String gravatarId;

    @SerializedName("url")
    private String url;

    @SerializedName("html_url")
    private String htmlUrl;

    @SerializedName("followers_url")
    private String followersUrl;

    @SerializedName("following_url")
    private String followingUrl;

    @SerializedName("gists_url")
    private String gistsUrl;

    @SerializedName("starred_url")
    private String starredUrl;

    @SerializedName("subscriptions_url")
    private String subscriptionsUrl;

    @SerializedName("organizations_url")
    private String organizationsUrl;

    @SerializedName("repos_url")
    private String reposUrl;

    @SerializedName("events_url")
    private String eventsUrl;

    @SerializedName("received_events_url")
    private String receivedEventsUrl;

    @SerializedName("type")
    private String type;

    @SerializedName("site_admin")
    private boolean siteAdmin;

    @SerializedName("name")
    private String name;

    @SerializedName("company")
    private String company;

    @SerializedName("blog")
    private String blog;

    @SerializedName("location")
    private String location;

    @SerializedName("email")
    private String email;

    @SerializedName("notification_email")
    private String notificationEmail;

    @SerializedName("hireable")
    private Boolean hireable;

    @SerializedName("bio")
    private String bio;

    @SerializedName("twitter_username")
    private String twitterUsername;

    @SerializedName("public_repos")
    private Integer publicRepos;

    @SerializedName("public_gists")
    private Integer publicGists;

    @SerializedName("followers")
    private Integer followers;

    @SerializedName("following")
    private Integer following;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("plan")
    private Plan plan;

    @SerializedName("private_gists")
    private Integer privateGists;

    @SerializedName("total_private_repos")
    private Integer totalPrivateRepos;

    @SerializedName("owned_private_repos")
    private Integer ownedPrivateRepos;

    @SerializedName("disk_usage")
    private Integer diskUsage;

    @SerializedName("collaborators")
    private Integer collaborators;

    /**
     * Plan details for a user
     */
    public static class Plan {
        @SerializedName("collaborators")
        private int collaborators;

        @SerializedName("name")
        private String name;

        @SerializedName("space")
        private int space;

        @SerializedName("private_repos")
        private int privateRepos;

        // Getters and setters
        public int getCollaborators() { return collaborators; }
        public void setCollaborators(int collaborators) { this.collaborators = collaborators; }

        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public int getSpace() { return space; }
        public void setSpace(int space) { this.space = space; }

        public int getPrivateRepos() { return privateRepos; }
        public void setPrivateRepos(int privateRepos) { this.privateRepos = privateRepos; }
    }

    // Getters and setters for PublicUser
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUserViewType() { return userViewType; }
    public void setUserViewType(String userViewType) { this.userViewType = userViewType; }

    public String getNodeId() { return nodeId; }
    public void setNodeId(String nodeId) { this.nodeId = nodeId; }

    public String getAvatarUrl() { return avatarUrl; }
    public void setAvatarUrl(String avatarUrl) { this.avatarUrl = avatarUrl; }

    public String getGravatarId() { return gravatarId; }
    public void setGravatarId(String gravatarId) { this.gravatarId = gravatarId; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public String getHtmlUrl() { return htmlUrl; }
    public void setHtmlUrl(String htmlUrl) { this.htmlUrl = htmlUrl; }

    public String getFollowersUrl() { return followersUrl; }
    public void setFollowersUrl(String followersUrl) { this.followersUrl = followersUrl; }

    public String getFollowingUrl() { return followingUrl; }
    public void setFollowingUrl(String followingUrl) { this.followingUrl = followingUrl; }

    public String getGistsUrl() { return gistsUrl; }
    public void setGistsUrl(String gistsUrl) { this.gistsUrl = gistsUrl; }

    public String getStarredUrl() { return starredUrl; }
    public void setStarredUrl(String starredUrl) { this.starredUrl = starredUrl; }

    public String getSubscriptionsUrl() { return subscriptionsUrl; }
    public void setSubscriptionsUrl(String subscriptionsUrl) { this.subscriptionsUrl = subscriptionsUrl; }

    public String getOrganizationsUrl() { return organizationsUrl; }
    public void setOrganizationsUrl(String organizationsUrl) { this.organizationsUrl = organizationsUrl; }

    public String getReposUrl() { return reposUrl; }
    public void setReposUrl(String reposUrl) { this.reposUrl = reposUrl; }

    public String getEventsUrl() { return eventsUrl; }
    public void setEventsUrl(String eventsUrl) { this.eventsUrl = eventsUrl; }

    public String getReceivedEventsUrl() { return receivedEventsUrl; }
    public void setReceivedEventsUrl(String receivedEventsUrl) { this.receivedEventsUrl = receivedEventsUrl; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public boolean isSiteAdmin() { return siteAdmin; }
    public void setSiteAdmin(boolean siteAdmin) { this.siteAdmin = siteAdmin; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public String getBlog() { return blog; }
    public void setBlog(String blog) { this.blog = blog; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getNotificationEmail() { return notificationEmail; }
    public void setNotificationEmail(String notificationEmail) { this.notificationEmail = notificationEmail; }

    public Boolean getHireable() { return hireable; }
    public void setHireable(Boolean hireable) { this.hireable = hireable; }

    public String getBio() { return bio; }
    public void setBio(String bio) { this.bio = bio; }

    public String getTwitterUsername() { return twitterUsername; }
    public void setTwitterUsername(String twitterUsername) { this.twitterUsername = twitterUsername; }

    public Integer getPublicRepos() { return publicRepos; }
    public void setPublicRepos(Integer publicRepos) { this.publicRepos = publicRepos; }

    public Integer getPublicGists() { return publicGists; }
    public void setPublicGists(Integer publicGists) { this.publicGists = publicGists; }

    public Integer getFollowers() { return followers; }
    public void setFollowers(Integer followers) { this.followers = followers; }

    public Integer getFollowing() { return following; }
    public void setFollowing(Integer following) { this.following = following; }

    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }

    public String getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }

    public Plan getPlan() { return plan; }
    public void setPlan(Plan plan) { this.plan = plan; }

    public Integer getPrivateGists() { return privateGists; }
    public void setPrivateGists(Integer privateGists) { this.privateGists = privateGists; }

    public Integer getTotalPrivateRepos() { return totalPrivateRepos; }
    public void setTotalPrivateRepos(Integer totalPrivateRepos) { this.totalPrivateRepos = totalPrivateRepos; }

    public Integer getOwnedPrivateRepos() { return ownedPrivateRepos; }
    public void setOwnedPrivateRepos(Integer ownedPrivateRepos) { this.ownedPrivateRepos = ownedPrivateRepos; }

    public Integer getDiskUsage() { return diskUsage; }
    public void setDiskUsage(Integer diskUsage) { this.diskUsage = diskUsage; }

    public Integer getCollaborators() { return collaborators; }
    public void setCollaborators(Integer collaborators) { this.collaborators = collaborators; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PublicUser)) return false;
        PublicUser that = (PublicUser) o;
        return siteAdmin == that.siteAdmin &&
                Objects.equals(login, that.login) &&
                Objects.equals(id, that.id) &&
                Objects.equals(userViewType, that.userViewType) &&
                Objects.equals(nodeId, that.nodeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, id, userViewType, nodeId, siteAdmin);
    }
}

