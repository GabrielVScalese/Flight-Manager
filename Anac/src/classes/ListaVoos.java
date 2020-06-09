package classes;

/**
 * A classe ListaVoos representa uma classe que armazena uma lista com todos os voos cadastrados.
 * Inst�ncias desta classe permitem a manuten��o desses voos.
 * Nela encontramos, por exemplo, metodos para inserir e remover, um construtor, equals etc.
 * @author Gabriel Villar Scalese && Guilherme Augusto Felisberto Teixeira.
 * @since 2020.
 */
import classes.ListaAeroportos.No;

public class ListaVoos implements Cloneable
{
    protected class No
    {
        protected Destino destino;
        protected No prox;
        protected No ante;

        public No (Destino destino, No p, No ante)
        {
            this.destino = destino;
            this.prox = p;
            this.ante = ante;
        }

        public No (Destino destino)
        {
            this.destino = destino;
            this.prox = null;
        }

        public Destino getDestino ()
        {
            return this.destino;
        }

        public No getProx ()
        {
            return this.prox;
        }
        
        public No getAnte ()
        {
        	return this.ante;
        }

        public void setDestino (Destino destino)
        {
            this.destino = destino;
        }

        public void setProx (No p)
        {
            this.prox = p;
        }
        
        public void setAnte (No ante)
        {
        	this.ante = ante;
        }
    }
    
    /**No Contendo o primeiro e o ultimo voo da lista. */
    protected No primeiro, ultimo;

    public void insiraNoFim (Destino destino) throws Exception
    {
    	if (destino == null)
            throw new Exception ("Informacao ausente");

        if (this.ultimo == null)
        {
            No novo = new No (destino);
            this.primeiro = novo;
            this.primeiro.setAnte(null);
            this.ultimo = this.primeiro;
            this.ultimo.setAnte(this.primeiro);
        }
        else
        {
            No valor = new No (destino, null, this.ultimo);
            this.ultimo.setProx(valor);
            this.ultimo = valor;
        }
    }

    /**
     * Gera uma representa��o textual de todo conte�do da ListaVoos.
     * Produz e resulta um String representando a lista de voos.
     * @return um String contendo representando a lista de voos.
     */
    public String toString ()
    {
        String ret = "Voos: ";

        No aux = this.primeiro;

        while (aux != null)
        {
            if (aux.getProx() != null)
                ret = ret + aux.getDestino() + "; ";
            else
                ret = ret + aux.getDestino();

            aux = aux.getProx();
        }

        return ret + "";
    }
    
    /**
     * Calcula o c�digo de espalhamento (ou c�digo de hash).
     * Calcula e resulta o c�digo de espalhamento (ou c�digo de hash, ou ainda o
     * hashcode) da classe ListaVoos representada pela inst�ncia � qual o m�todo for aplicado.
     * @return o c�digo de espalhamento do objeto chamante da classe ListaVoos.
     */
    public int hashCode ()
    {
        int ret = 17;
        No aux = this.primeiro;

        while (aux != null)
        {
            ret = ret * 17 + aux.getDestino().hashCode();

            aux = aux.getProx();
        }

        if (ret < 0)
            ret = -ret;

        return ret;
    }

    /**
     * Verifica a igualdade entre dois ListaVoos.
     * Verifica se o Object fornecido como par�metro representa um
     * ListaVoos igual �quele representado pela inst�ncia � qual este
     * m�todo for aplicado, resultando true em caso afirmativo,
     * ou false, caso contr�rio.
     * @param  obj o objeto a ser comparado com a inst�ncia � qual esse m�todo
     * for aplicado.
     * @return true, caso o Object fornecido ao m�todo e a inst�ncia chamante do
     * m�todo representarem ListaVoos iguais, ou false, caso contr�rio.
     */
    public boolean equals (Object obj)
    {
        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (this.getClass() != obj.getClass())
            return false;

        ListaVoos lis = (ListaVoos)obj;

        No aux1 = this.primeiro;
        No aux2 = lis.primeiro;

        while (aux1 != null && aux2 != null)
        {
            if (aux1.getDestino().equals(aux2.getDestino()) == false)
                return false;

            aux1 = aux1.getProx();
            aux2 = aux2.getProx();
        }

        return true;
    }
    
    public void removaVoo (int numeroDoVoo) throws Exception
    {
        if (this.ultimo == null & this.primeiro == null)
            throw new Exception ("Lista esta vazia");

        if (this.primeiro.getDestino().getNumeroVoo() == numeroDoVoo)
        {
            No guardado = this.primeiro;
            this.primeiro = guardado.getProx();
            this.primeiro.setAnte(null);
            return;
        }

        if (this.ultimo.getDestino().getNumeroVoo() == numeroDoVoo)
        {
        	No guardado = this.ultimo.getAnte();
        	this.ultimo.getAnte().setProx(null);
        	this.ultimo = guardado;
        	return;
        }
        
        No aux = this.primeiro;
        while (aux != null)
        {
            if (aux.getProx().getDestino().getNumeroVoo() == numeroDoVoo)
            {
                No guardado = aux.getProx().getProx();
                guardado.setAnte(aux);
                aux.setProx(guardado);
                break;
            }
            aux = aux.getProx();
        }
    }

    public boolean temVoo (int numeroVoo)
    {
         No aux = this.primeiro;

         while (aux != null)
         {
             if (aux.getDestino() == null)
                 aux = aux.getProx();
             else
             {
                 if (aux.getDestino().getNumeroVoo() == numeroVoo)
                 {
                     return true;
                 }
                 else
                     aux = aux.getProx();
             }
         }

         return false;
    }
    
    /**
     * Constroi uma c�pia deste ListaVoos.
     * Utiliza o construtor de c�pia para gerar uma c�pia de this e a retorna.
     * @return a c�pia deste ListaVoos como Object.
     */
    public Object clone ()
    {
        ListaVoos ret = null;
        try
        {
            ret = new ListaVoos(this);
        }
        catch (Exception erro)
        {}

        return ret;
    }

    /**
     * Constroi uma c�pia da inst�ncia da classe ListaVoos dada.
     * Para tanto, deve ser fornecida uma instancia da classe ListaVoos para ser
     * utilizada como modelo para a constru��o da nova inst�ncia criada.
     * @param modelo a inst�ncia da classe ListaVoos a ser usada como modelo.
     * @throws Exception se o modelo for null.
     */
    public ListaVoos (ListaVoos modelo) throws Exception
    {
        if (modelo == null)
            throw new Exception ("Modelo ausente");

        this.primeiro = modelo.primeiro;
        this.ultimo = modelo.ultimo;
        No aux = this.primeiro;
        No aux2 = modelo.primeiro;
        while (aux != null)
        {
            aux.setDestino(aux2.getDestino());

            aux = aux.getProx();
            aux2 = aux2.getProx();
        }
    }

    public ListaVoos ()
    {}

    public Destino getDoInicio() throws Exception
    {
        if (this.ultimo == null && this.primeiro == null)
            throw new Exception ("Lista esta vazia");

        return this.primeiro.getDestino();
    }
    
    public Destino getProxDestino (Destino destino)
    {
    	No aux = this.primeiro;
    	while (aux != null)
    	{
    		if (aux.getDestino().equals(destino))
    		{
    			if (aux.getProx() != null)
    			   return aux.getProx().getDestino();
    			else
    				return null;
    		}
    		else
    		{
    			aux = aux.getProx();
    		}
    	}
    	
    	return null;
    }
    
    public Destino getAnteDestino (Destino destino)
    {
    	No aux = this.primeiro;
    	while (aux != null)
    	{
    		if (aux.getDestino().equals(destino))
    		{
    			return aux.getAnte().getDestino();
    		}
    		else
    		{
    			aux = aux.getProx();
    		}
    	}
    	
    	return null;
    }

    public Destino getDoFim() throws Exception
    {
        if (this.ultimo == null && this.primeiro == null)
            throw new Exception ("Lista esta vazia");

        return this.ultimo.getDestino();
    }

    public int getQtd ()
    {
        No aux = this.primeiro;
        int qtd = 0;
        while (aux != null)
        {
            qtd++;
            aux = aux.getProx();
        }

        return qtd;
    }
}