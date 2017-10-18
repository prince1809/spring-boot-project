package com.princekr.boot.maven;

import org.apache.maven.plugins.annotations.Parameter;

/**
 * Created by prince on 2017/10/19.
 */
public abstract class FilterableDependency {

    /**
     * The groupId of the artifact to exclude
     */
    @Parameter(required = true)
    private String groupId;

    /**
     * The artifactId of the artifact to exclude
     */
    @Parameter(required = true)
    private String artifactId;

    @Parameter
    private String classifier;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }

    public String getClassifier() {
        return classifier;
    }

    public void setClassifier(String classifier) {
        this.classifier = classifier;
    }
}
