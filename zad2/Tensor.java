package zadaniaDomowe.zad2;

public abstract class Tensor implements Addable<Tensor>, Scalable<Tensor>, DotProduct<Tensor> {
    protected int n;
    public int getN() {return n;}

    @Override
    public abstract Tensor add(Tensor other);

    @Override
    public abstract Tensor multiply(double scalar);

    @Override
    public abstract double dot(Tensor other);

    @Override
    public abstract String toString();
}
