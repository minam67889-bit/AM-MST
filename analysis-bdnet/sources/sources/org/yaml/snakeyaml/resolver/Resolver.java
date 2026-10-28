package org.yaml.snakeyaml.resolver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.yaml.snakeyaml.nodes.NodeId;
import org.yaml.snakeyaml.nodes.Tag;

/* loaded from: classes2.dex */
public class Resolver {
    protected Map<Character, List<ResolverTuple>> yamlImplicitResolvers;
    public static final Pattern BOOL = Pattern.compile("^(?:yes|Yes|YES|no|No|NO|true|True|TRUE|false|False|FALSE|on|On|ON|off|Off|OFF)$");
    public static final Pattern FLOAT = Pattern.compile("^([-+]?(\\.[0-9]+|[0-9_]+(\\.[0-9_]*)?)([eE][-+]?[0-9]+)?|[-+]?[0-9][0-9_]*(?::[0-5]?[0-9])+\\.[0-9_]*|[-+]?\\.(?:inf|Inf|INF)|\\.(?:nan|NaN|NAN))$");
    public static final Pattern INT = Pattern.compile("^(?:[-+]?0b[0-1_]+|[-+]?0[0-7_]+|[-+]?(?:0|[1-9][0-9_]*)|[-+]?0x[0-9a-fA-F_]+|[-+]?[1-9][0-9_]*(?::[0-5]?[0-9])+)$");
    public static final Pattern MERGE = Pattern.compile("^(?:<<)$");
    public static final Pattern NULL = Pattern.compile("^(?:~|null|Null|NULL| )$");
    public static final Pattern EMPTY = Pattern.compile("^$");
    public static final Pattern TIMESTAMP = Pattern.compile("^(?:[0-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9]|[0-9][0-9][0-9][0-9]-[0-9][0-9]?-[0-9][0-9]?(?:[Tt]|[ \t]+)[0-9][0-9]?:[0-9][0-9]:[0-9][0-9](?:\\.[0-9]*)?(?:[ \t]*(?:Z|[-+][0-9][0-9]?(?::[0-9][0-9])?))?)$");
    public static final Pattern VALUE = Pattern.compile("^(?:=)$");
    public static final Pattern YAML = Pattern.compile("^(?:!|&|\\*)$");

    /* renamed from: org.yaml.snakeyaml.resolver.Resolver$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$yaml$snakeyaml$nodes$NodeId;

        static {
            int[] iArr = new int[NodeId.values().length];
            $SwitchMap$org$yaml$snakeyaml$nodes$NodeId = iArr;
            try {
                iArr[NodeId.scalar.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$yaml$snakeyaml$nodes$NodeId[NodeId.sequence.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public Resolver(boolean z) {
        this.yamlImplicitResolvers = new HashMap();
        if (z) {
            addImplicitResolvers();
        }
    }

    public void addImplicitResolver(Tag tag, Pattern pattern, String str) {
        if (str == null) {
            List<ResolverTuple> list = this.yamlImplicitResolvers.get(null);
            if (list == null) {
                list = new ArrayList<>();
                this.yamlImplicitResolvers.put(null, list);
            }
            list.add(new ResolverTuple(tag, pattern));
            return;
        }
        for (char c : str.toCharArray()) {
            Character valueOf = Character.valueOf(c);
            if (c == 0) {
                valueOf = null;
            }
            List<ResolverTuple> list2 = this.yamlImplicitResolvers.get(valueOf);
            if (list2 == null) {
                list2 = new ArrayList<>();
                this.yamlImplicitResolvers.put(valueOf, list2);
            }
            list2.add(new ResolverTuple(tag, pattern));
        }
    }

    public void addImplicitResolvers() {
        addImplicitResolver(Tag.BOOL, BOOL, "yYnNtTfFoO");
        addImplicitResolver(Tag.INT, INT, "-+0123456789");
        addImplicitResolver(Tag.FLOAT, FLOAT, "-+0123456789.");
        addImplicitResolver(Tag.MERGE, MERGE, "<");
        Tag tag = Tag.NULL;
        addImplicitResolver(tag, NULL, "~nN\u0000");
        addImplicitResolver(tag, EMPTY, null);
        addImplicitResolver(Tag.TIMESTAMP, TIMESTAMP, "0123456789");
        addImplicitResolver(Tag.VALUE, VALUE, "=");
        addImplicitResolver(Tag.YAML, YAML, "!&*");
    }

    public Tag resolve(NodeId nodeId, String str, boolean z) {
        if (nodeId == NodeId.scalar && z) {
            List<ResolverTuple> list = str.length() == 0 ? this.yamlImplicitResolvers.get((char) 0) : this.yamlImplicitResolvers.get(Character.valueOf(str.charAt(0)));
            if (list != null) {
                for (ResolverTuple resolverTuple : list) {
                    Tag tag = resolverTuple.getTag();
                    if (resolverTuple.getRegexp().matcher(str).matches()) {
                        return tag;
                    }
                }
            }
            if (this.yamlImplicitResolvers.containsKey(null)) {
                for (ResolverTuple resolverTuple2 : this.yamlImplicitResolvers.get(null)) {
                    Tag tag2 = resolverTuple2.getTag();
                    if (resolverTuple2.getRegexp().matcher(str).matches()) {
                        return tag2;
                    }
                }
            }
        }
        int i = AnonymousClass1.$SwitchMap$org$yaml$snakeyaml$nodes$NodeId[nodeId.ordinal()];
        return i != 1 ? i != 2 ? Tag.MAP : Tag.SEQ : Tag.STR;
    }

    public Resolver() {
        this(true);
    }
}
