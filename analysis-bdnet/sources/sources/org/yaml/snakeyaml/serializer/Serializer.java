package org.yaml.snakeyaml.serializer;

import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import defpackage.W50;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.emitter.Emitable;
import org.yaml.snakeyaml.events.AliasEvent;
import org.yaml.snakeyaml.events.DocumentEndEvent;
import org.yaml.snakeyaml.events.DocumentStartEvent;
import org.yaml.snakeyaml.events.ImplicitTuple;
import org.yaml.snakeyaml.events.MappingEndEvent;
import org.yaml.snakeyaml.events.MappingStartEvent;
import org.yaml.snakeyaml.events.ScalarEvent;
import org.yaml.snakeyaml.events.SequenceEndEvent;
import org.yaml.snakeyaml.events.SequenceStartEvent;
import org.yaml.snakeyaml.events.StreamEndEvent;
import org.yaml.snakeyaml.events.StreamStartEvent;
import org.yaml.snakeyaml.nodes.AnchorNode;
import org.yaml.snakeyaml.nodes.CollectionNode;
import org.yaml.snakeyaml.nodes.MappingNode;
import org.yaml.snakeyaml.nodes.Node;
import org.yaml.snakeyaml.nodes.NodeId;
import org.yaml.snakeyaml.nodes.NodeTuple;
import org.yaml.snakeyaml.nodes.ScalarNode;
import org.yaml.snakeyaml.nodes.SequenceNode;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.resolver.Resolver;

/* loaded from: classes2.dex */
public final class Serializer {
    private Map<Node, String> anchors;
    private Boolean closed;
    private final Emitable emitter;
    private boolean explicitEnd;
    private Tag explicitRoot;
    private boolean explicitStart;
    private int lastAnchorId;
    private final Resolver resolver;
    private Set<Node> serializedNodes;
    private Map<String, String> useTags;
    private Integer[] useVersion;

    /* renamed from: org.yaml.snakeyaml.serializer.Serializer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$yaml$snakeyaml$nodes$NodeId;

        static {
            int[] iArr = new int[NodeId.values().length];
            $SwitchMap$org$yaml$snakeyaml$nodes$NodeId = iArr;
            try {
                iArr[NodeId.sequence.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$yaml$snakeyaml$nodes$NodeId[NodeId.mapping.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$yaml$snakeyaml$nodes$NodeId[NodeId.scalar.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public Serializer(Emitable emitable, Resolver resolver, DumperOptions dumperOptions, Tag tag) {
        this.emitter = emitable;
        this.resolver = resolver;
        this.explicitStart = dumperOptions.isExplicitStart();
        this.explicitEnd = dumperOptions.isExplicitEnd();
        if (dumperOptions.getVersion() != null) {
            this.useVersion = dumperOptions.getVersion().getArray();
        }
        this.useTags = dumperOptions.getTags();
        this.serializedNodes = new HashSet();
        this.anchors = new HashMap();
        this.lastAnchorId = 0;
        this.closed = null;
        this.explicitRoot = tag;
    }

    private void anchorNode(Node node) {
        if (node.getNodeId() == NodeId.anchor) {
            node = ((AnchorNode) node).getRealNode();
        }
        if (this.anchors.containsKey(node)) {
            if (this.anchors.get(node) == null) {
                this.anchors.put(node, generateAnchor());
                return;
            }
            return;
        }
        this.anchors.put(node, null);
        int i = AnonymousClass1.$SwitchMap$org$yaml$snakeyaml$nodes$NodeId[node.getNodeId().ordinal()];
        if (i == 1) {
            Iterator<Node> it = ((SequenceNode) node).getValue().iterator();
            while (it.hasNext()) {
                anchorNode(it.next());
            }
        } else {
            if (i != 2) {
                return;
            }
            for (NodeTuple nodeTuple : ((MappingNode) node).getValue()) {
                Node keyNode = nodeTuple.getKeyNode();
                Node valueNode = nodeTuple.getValueNode();
                anchorNode(keyNode);
                anchorNode(valueNode);
            }
        }
    }

    private String generateAnchor() {
        this.lastAnchorId++;
        NumberFormat numberInstance = NumberFormat.getNumberInstance();
        numberInstance.setMinimumIntegerDigits(3);
        numberInstance.setGroupingUsed(false);
        return W50.m(FacebookMediationAdapter.KEY_ID, numberInstance.format(this.lastAnchorId));
    }

    private void serializeNode(Node node, Node node2) {
        if (node.getNodeId() == NodeId.anchor) {
            node = ((AnchorNode) node).getRealNode();
        }
        String str = this.anchors.get(node);
        if (this.serializedNodes.contains(node)) {
            this.emitter.emit(new AliasEvent(str, null, null));
            return;
        }
        this.serializedNodes.add(node);
        int i = AnonymousClass1.$SwitchMap$org$yaml$snakeyaml$nodes$NodeId[node.getNodeId().ordinal()];
        if (i == 1) {
            SequenceNode sequenceNode = (SequenceNode) node;
            this.emitter.emit(new SequenceStartEvent(str, node.getTag().getValue(), node.getTag().equals(this.resolver.resolve(NodeId.sequence, null, true)), null, null, sequenceNode.getFlowStyle()));
            Iterator<Node> it = sequenceNode.getValue().iterator();
            while (it.hasNext()) {
                serializeNode(it.next(), node);
            }
            this.emitter.emit(new SequenceEndEvent(null, null));
            return;
        }
        if (i == 3) {
            ScalarNode scalarNode = (ScalarNode) node;
            Resolver resolver = this.resolver;
            NodeId nodeId = NodeId.scalar;
            this.emitter.emit(new ScalarEvent(str, node.getTag().getValue(), new ImplicitTuple(node.getTag().equals(resolver.resolve(nodeId, scalarNode.getValue(), true)), node.getTag().equals(this.resolver.resolve(nodeId, scalarNode.getValue(), false))), scalarNode.getValue(), null, null, scalarNode.getStyle()));
            return;
        }
        this.emitter.emit(new MappingStartEvent(str, node.getTag().getValue(), node.getTag().equals(this.resolver.resolve(NodeId.mapping, null, true)), null, null, ((CollectionNode) node).getFlowStyle()));
        MappingNode mappingNode = (MappingNode) node;
        for (NodeTuple nodeTuple : mappingNode.getValue()) {
            Node keyNode = nodeTuple.getKeyNode();
            Node valueNode = nodeTuple.getValueNode();
            serializeNode(keyNode, mappingNode);
            serializeNode(valueNode, mappingNode);
        }
        this.emitter.emit(new MappingEndEvent(null, null));
    }

    public void close() {
        Boolean bool = this.closed;
        if (bool == null) {
            throw new SerializerException("serializer is not opened");
        }
        Boolean bool2 = Boolean.TRUE;
        if (bool2.equals(bool)) {
            return;
        }
        this.emitter.emit(new StreamEndEvent(null, null));
        this.closed = bool2;
    }

    public void open() {
        Boolean bool = this.closed;
        if (bool == null) {
            this.emitter.emit(new StreamStartEvent(null, null));
            this.closed = Boolean.FALSE;
        } else {
            if (!Boolean.TRUE.equals(bool)) {
                throw new SerializerException("serializer is already opened");
            }
            throw new SerializerException("serializer is closed");
        }
    }

    public void serialize(Node node) {
        Boolean bool = this.closed;
        if (bool == null) {
            throw new SerializerException("serializer is not opened");
        }
        if (bool.booleanValue()) {
            throw new SerializerException("serializer is closed");
        }
        this.emitter.emit(new DocumentStartEvent(null, null, this.explicitStart, this.useVersion, this.useTags));
        anchorNode(node);
        Tag tag = this.explicitRoot;
        if (tag != null) {
            node.setTag(tag);
        }
        serializeNode(node, null);
        this.emitter.emit(new DocumentEndEvent(null, null, this.explicitEnd));
        this.serializedNodes.clear();
        this.anchors.clear();
        this.lastAnchorId = 0;
    }
}
