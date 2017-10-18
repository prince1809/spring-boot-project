package com.princekr.boot.maven;

import org.apache.maven.artifact.Artifact;

import java.util.List;

/**
 * Created by prince on 2017/10/19.
 */
public class IncludeFilter extends DependencyFilter {

    public IncludeFilter(List<Include> includes) {
        super(includes);
    }

    @Override
    protected boolean filter(Artifact artifact) {
        for (FilterableDependency dependency : getFilters()) {
            if (equals(artifact, dependency)) {
                return false;
            }
        }
        return true;
    }
}
