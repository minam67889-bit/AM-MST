package org.yaml.snakeyaml;

import org.yaml.snakeyaml.constructor.BaseConstructor;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.resolver.Resolver;

/* loaded from: classes2.dex */
public final class Loader {
    protected final BaseConstructor constructor;
    protected Resolver resolver;

    public Loader(BaseConstructor baseConstructor) {
        this.constructor = baseConstructor;
    }

    public Loader() {
        this(new Constructor());
    }
}
