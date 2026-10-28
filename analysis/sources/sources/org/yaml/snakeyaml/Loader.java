package org.yaml.snakeyaml;

import org.yaml.snakeyaml.constructor.BaseConstructor;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.resolver.Resolver;

/* loaded from: classes2.dex */
public final class Loader {
    protected final BaseConstructor constructor;
    protected Resolver resolver;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Loader() {
        this(new Constructor());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Loader(BaseConstructor baseConstructor) {
        this.constructor = baseConstructor;
    }
}
