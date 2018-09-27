public class ForStatement implements Statement
{
    private Id var;
    private Iter it; //arrayList of size 2, index 0-start loop value, index 1-end loop value
    private Block blk;

    public ForStatement(Id var, Iter it, Block blk)
    {
        if (var == null)
            throw new IllegalArgumentException ("null Id argument");
        if (it == null)
            throw new IllegalArgumentException ("null iterator argument");
        if (blk == null)
            throw new IllegalArgumentException ("null block argument");

        this.var = var;
        this.it = it;
        this.blk = blk;
    }

    @Override
    public void execute()
    {   //incrementing loop
        if(it.evaluate().get(0) < it.evaluate().get(1)) {
            Memory.store(var.getChar(), it.evaluate().get(0));
            while(Memory.fetch(var.getChar()) <= it.evaluate().get(1)) {
                blk.execute();
                int i = Memory.fetch(var.getChar());
                i++;
                Memory.store(var.getChar(), i);
            }
        }
        else { //decrementing loop
            Memory.store(var.getChar(), it.evaluate().get(0));
            while(Memory.fetch(var.getChar()) >= it.evaluate().get(1)) {
                blk.execute();
                int i = Memory.fetch(var.getChar());
                i--;
                Memory.store(var.getChar(), i);
            }
        }
    }
}
