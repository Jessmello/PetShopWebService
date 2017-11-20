package petshop;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import petshop.Animal;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-20T15:10:02")
@StaticMetamodel(Produto.class)
public class Produto_ { 

    public static volatile SingularAttribute<Produto, String> marca;
    public static volatile SingularAttribute<Produto, Animal> idAnimal;
    public static volatile SingularAttribute<Produto, Integer> cdTipoProduto;
    public static volatile SingularAttribute<Produto, Float> valor;
    public static volatile SingularAttribute<Produto, String> nome;
    public static volatile SingularAttribute<Produto, Long> id;
    public static volatile SingularAttribute<Produto, String> descricao;

}