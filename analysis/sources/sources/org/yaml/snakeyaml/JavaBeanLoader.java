package org.yaml.snakeyaml;

import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.introspector.BeanAccess;
import org.yaml.snakeyaml.reader.UnicodeReader;
import org.yaml.snakeyaml.representer.Representer;
import org.yaml.snakeyaml.resolver.Resolver;

/* loaded from: classes2.dex */
public class JavaBeanLoader<T> {
    private Yaml loader;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <S extends T> JavaBeanLoader(Class<S> cls) {
        this(cls, BeanAccess.DEFAULT);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T load(InputStream inputStream) {
        return (T) this.loader.load(new UnicodeReader(inputStream));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <S extends T> JavaBeanLoader(Class<S> cls, BeanAccess beanAccess) {
        this(new TypeDescription(cls), beanAccess);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T load(Reader reader) {
        return (T) this.loader.load(reader);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JavaBeanLoader(LoaderOptions loaderOptions, BeanAccess beanAccess) {
        if (loaderOptions == null) {
            throw new NullPointerException("LoaderOptions must be provided.");
        }
        if (loaderOptions.getRootTypeDescription() == null) {
            throw new NullPointerException("TypeDescription must be provided.");
        }
        Yaml yaml = new Yaml(new Constructor(loaderOptions.getRootTypeDescription()), loaderOptions, new Representer(), new DumperOptions(), new Resolver());
        this.loader = yaml;
        yaml.setBeanAccess(beanAccess);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T load(String str) {
        return (T) this.loader.load(new StringReader(str));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JavaBeanLoader(TypeDescription typeDescription) {
        this(typeDescription, BeanAccess.DEFAULT);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JavaBeanLoader(TypeDescription typeDescription, BeanAccess beanAccess) {
        this(new LoaderOptions(typeDescription), beanAccess);
    }
}
