package org.yaml.snakeyaml.resolver;

import com.liapp.y;
import java.util.regex.Pattern;
import org.yaml.snakeyaml.nodes.Tag;

/* loaded from: classes2.dex */
final class ResolverTuple {
    private final Pattern regexp;
    private final Tag tag;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ResolverTuple(Tag tag, Pattern pattern) {
        this.tag = tag;
        this.regexp = pattern;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Pattern getRegexp() {
        return this.regexp;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Tag getTag() {
        return this.tag;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return y.׬ܮ֮ڱܭ(1520030728) + this.tag + y.ش۳ֲ׬٨(1672268514) + this.regexp;
    }
}
