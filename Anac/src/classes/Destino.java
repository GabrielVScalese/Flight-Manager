package classes;

/**
 * A classe Destino representa uma classe que armazena os destinos dos voos.  Inst�ncias desta classe permitem o 
 * armazenamento do indice do voo e o numero do voo.
 * Nela encontramos, por exemplo, getters, setters, um construtor, equals etc.
 * @author Gabriel Villar Scalese && Guilherme Augusto Felisberto Teixeira.
 * @since 2020.
 */


import java.util.concurrent.LinkedBlockingDeque;

public class Destino implements Cloneable // Armazena o indice da cidade e o numero do voo
{
	/**Integer onde o Indice ser� armazenado. */
    protected int indice;
    /**Integer onde o numero do voo ser� armazenado. */
    protected int numeroVoo;

    /**
     * Constroi uma nova inst�ncia da classe Destino.
     * @param indice int contedo o indice do destino.
     * @param numeroVoo int contendo o numero do voo.
     * @throws Exception se ocorrer algum erro nos Setters.
     *  */
    public Destino (int indice, int numeroVoo) throws Exception
    {
        setIndice(indice);
        setNumeroVoo(numeroVoo);
    }

    /**
     * Adiciona valores ao int indice.
     * @param indice int contedo o indice do destino.
     * @throws Exception se o indice passado por parametro for menor que zero.
     *  */
    public void setIndice (int indice) throws Exception
    {
        if (indice < 0)
            throw new Exception ("Indice invalido");

        this.indice = indice;
    }

    /**
     * Adiciona valores ao int numeroVoo.
     * @param numeroVoo int contedo o numero do voo.
     * @throws Exception se o numeroVoo passado por parametro for menor que zero.
     *  */
    public void setNumeroVoo (int numeroVoo) throws Exception
    {
        if (numeroVoo < 0)
            throw new Exception ("Numero de voo invalido");

        this.numeroVoo = numeroVoo;
    }
    
    /**
     * Retorna o indice do destino.
     * @return  Retorna o valor presente no int indice. 
     *  */
    public int getIndice ()
    {
        return this.indice;
    }

    /**
     * Retorna o numero do voo.
     * @return  Retorna o valor presente no int numeroVoo. 
     *  */
    public int getNumeroVoo ()
    {
        return this.numeroVoo;
    }

    /**
     * Verifica a igualdade entre dois Destino.
     * Verifica se o Object fornecido como par�metro representa um
     * Destino igual �quele representado pela inst�ncia � qual este
     * m�todo for aplicado, resultando true em caso afirmativo,
     * ou false, caso contr�rio.
     * @param  obj o objeto a ser comparado com a inst�ncia � qual esse m�todo
     * for aplicado.
     * @return true, caso o Object fornecido ao m�todo e a inst�ncia chamante do
     * m�todo representarem Destino iguais, ou false, caso contr�rio.
     */
    public boolean equals (Object obj)
    {
        if (obj == null)
            return false;

        if (this == obj)
            return true;

        if (this.getClass() != obj.getClass())
            return false;

        Destino des = (Destino)obj;

        if (this.indice != des.indice)
            return false;

        if (this.numeroVoo != des.numeroVoo)
            return false;

        return true;
    }

    /**
     * Gera uma representa��o textual de todo conte�do do Destino.
     * Produz e resulta um String representando o Indice e o numero do voo.
     * @return um String contendo representando o Indice e o numero do voo.
     */
    public String toString ()
    {
        return "Indice: " + this.indice + " e " + "Numero do voo: " + this.numeroVoo;
    }


    /**
     * Calcula o c�digo de espalhamento (ou c�digo de hash).
     * Calcula e resulta o c�digo de espalhamento (ou c�digo de hash, ou ainda o
     * hashcode) da classe Destino representada pela inst�ncia � qual o m�todo for aplicado.
     * @return o c�digo de espalhamento do objeto chamante da classe Destino.
     */
    public int hashCode ()
    {
        int ret = 17;

        ret = ret * 17 + Integer.valueOf(this.indice).hashCode();
        ret = ret * 17 + Integer.valueOf(this.numeroVoo).hashCode();

        if (ret < 0)
            ret = -ret;

        return ret;
    }
    /**
     * Verifica se o indice e o numeroVoo dessa inst�ncia da classe � maior que o de outra classe passada por parametro.
     * @param obj Classe cujo indice e numeroVoo ser�o comparados.
     * @retun 1, se essa inst�ncia for maior, -1 se for menor, e 0 se for igual.
     * */

    public int compareTo (Destino obj)
    {
        if (this.indice > obj.indice)
            return 1;

        if (this.indice < obj.indice)
            return -1;

        if (this.numeroVoo > obj.numeroVoo)
            return 1;

        if (this.numeroVoo < obj.numeroVoo)
            return -1;

        return 0;
    }

    /**
     * Constroi uma c�pia deste Destino.
     * Utiliza o construtor de c�pia para gerar uma c�pia de this e a retorna.
     * @return a c�pia deste Destino como Object.
     */
    public Object clone ()
    {
        Destino ret = null;
        try
        {
            ret = new Destino(this);
        }
        catch (Exception e)
        {}

        return ret;
    }
    
    /**
     * Constroi uma c�pia da inst�ncia da classe Destino dada.
     * Para tanto, deve ser fornecida uma instancia da classe Destino para ser
     * utilizada como modelo para a constru��o da nova inst�ncia criada.
     * @param modelo a inst�ncia da classe Destino a ser usada como modelo.
     * @throws Exception se o modelo for null.
     */
    public Destino (Destino modelo) throws Exception
    {
        if (modelo == null)
            throw new Exception ("Modelo invalido");

        this.indice = modelo.indice;
        this.numeroVoo = modelo.numeroVoo;
    }
}