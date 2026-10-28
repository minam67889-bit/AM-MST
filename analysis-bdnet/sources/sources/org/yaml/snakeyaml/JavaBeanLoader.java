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

    public JavaBeanLoader(TypeDescription typeDescription) {
        this(typeDescription, BeanAccess.DEFAULT);
    }

    public T load(String str) {
        return (T) this.loader.load(new StringReader(str));
    }

    public JavaBeanLoader(TypeDescription typeDescription, BeanAccess beanAccess) {
        this(new LoaderOptions(typeDescription), beanAccess);
    }

    public T load(InputStream inputStream) {
        return (T) this.loader.load(new UnicodeReader(inputStream));
    }

    public JavaBeanLoader(LoaderOptions loaderOptions, BeanAccess beanAccess) {
        if (loaderOptions != null) {
            if (loaderOptions.getRootTypeDescription() != null) {
                Yaml yaml = new Yaml(new Constructor(loaderOptions.getRootTypeDescription()), loaderOptions, new Representer(), new DumperOptions(), new Resolver());
                this.loader = yaml;
                yaml.setBeanAccess(beanAccess);
                return;
            }
            throw new NullPointerException("TypeDescription must be provided.");
        }
        throw new NullPointerException("LoaderOptions must be provided.");
    }

    public T load(Reader reader) {
        return (T) this.loader.load(reader);
    }

    public <S extends T> JavaBeanLoader(Class<S> cls, BeanAccess beanAccess) {
        this(new TypeDescription(cls), beanAccess);
    }

    public <S extends T> JavaBeanLoader(Class<S> cls) {
        this(cls, BeanAccess.DEFAULT);
    }
}
