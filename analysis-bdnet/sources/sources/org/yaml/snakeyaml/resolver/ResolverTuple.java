package org.yaml.snakeyaml.resolver;

import java.util.regex.Pattern;
import org.yaml.snakeyaml.nodes.Tag;

/* loaded from: classes2.dex */
final class ResolverTuple {
    private final Pattern regexp;
    private final Tag tag;

    public ResolverTuple(Tag tag, Pattern pattern) {
        this.tag = tag;
        this.regexp = pattern;
    }

    public Pattern getRegexp() {
        return this.regexp;
    }

    public Tag getTag() {
        return this.tag;
    }

    public String toString() {
        return "Tuple tag=" + this.tag + " regexp=" + this.regexp;
    }
}
