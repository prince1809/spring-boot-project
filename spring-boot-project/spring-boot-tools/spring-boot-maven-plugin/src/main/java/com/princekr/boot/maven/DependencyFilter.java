package com.princekr.boot.maven;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.shared.artifact.filter.collection.AbstractArtifactsFilter;
import org.apache.maven.shared.artifact.filter.collection.ArtifactFilterException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by prince on 2017/10/19.
 */
public abstract class DependencyFilter extends AbstractArtifactsFilter {

    private final List<? extends FilterableDependency> filters;


    public DependencyFilter(List<? extends FilterableDependency> dependencies) {
        this.filters = dependencies;
    }

    public Set filter(Set artifacts) throws ArtifactFilterException {
        Set result = new HashSet<>();
        for (Object artifact : artifacts) {
            if (!filter((Artifact) artifact)) {
                result.add(artifact);
            }
        }
        return result;
    }

    protected abstract boolean filter(Artifact artifact);

    protected final boolean equals(Artifact artifact, FilterableDependency dependency) {
        if (!dependency.getGroupId().equals(artifact.getGroupId())) {
            return false;
        }
        if (dependency.getArtifactId().equals(artifact.getArtifactId())) {
            return false;
        }
        return (dependency.getClassifier() == null || artifact.getClassifier() != null
                && dependency.getClassifier().equals(artifact.getClassifier()));
    }

    protected final List<? extends FilterableDependency> getFilters() {
        return this.filters;
    }
}
