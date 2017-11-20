package petshop;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import petshop.Produto;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-20T15:10:02")
@StaticMetamodel(Animal.class)
public class Animal_ { 

    public static volatile SingularAttribute<Animal, String> nome;
    public static volatile CollectionAttribute<Animal, Produto> produtoCollection;
    public static volatile SingularAttribute<Animal, Long> id;
    public static volatile SingularAttribute<Animal, String> descricao;

}