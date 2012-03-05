/* This file was generated by SableCC (http://www.sablecc.org/). */

package simpleAdder.parser;

import simpleAdder.lexer.*;
import simpleAdder.node.*;
import simpleAdder.analysis.*;
import java.util.*;

import java.io.DataInputStream;
import java.io.BufferedInputStream;
import java.io.IOException;

@SuppressWarnings("nls")
public class Parser
{
    public final Analysis ignoredTokens = new AnalysisAdapter();

    protected ArrayList nodeList;

    private final Lexer lexer;
    private final ListIterator stack = new LinkedList().listIterator();
    private int last_pos;
    private int last_line;
    private Token last_token;
    private final TokenIndex converter = new TokenIndex();
    private final int[] action = new int[2];

    private final static int SHIFT = 0;
    private final static int REDUCE = 1;
    private final static int ACCEPT = 2;
    private final static int ERROR = 3;

    public Parser(@SuppressWarnings("hiding") Lexer lexer)
    {
        this.lexer = lexer;
    }

    protected void filter() throws ParserException, LexerException, IOException
    {
        // Empty body
    }

    private void push(int numstate, ArrayList listNode, boolean hidden) throws ParserException, LexerException, IOException
    {
        this.nodeList = listNode;

        if(!hidden)
        {
            filter();
        }

        if(!this.stack.hasNext())
        {
            this.stack.add(new State(numstate, this.nodeList));
            return;
        }

        State s = (State) this.stack.next();
        s.state = numstate;
        s.nodes = this.nodeList;
    }

    private int goTo(int index)
    {
        int state = state();
        int low = 1;
        int high = gotoTable[index].length - 1;
        int value = gotoTable[index][0][1];

        while(low <= high)
        {
            int middle = (low + high) / 2;

            if(state < gotoTable[index][middle][0])
            {
                high = middle - 1;
            }
            else if(state > gotoTable[index][middle][0])
            {
                low = middle + 1;
            }
            else
            {
                value = gotoTable[index][middle][1];
                break;
            }
        }

        return value;
    }

    private int state()
    {
        State s = (State) this.stack.previous();
        this.stack.next();
        return s.state;
    }

    private ArrayList pop()
    {
        return ((State) this.stack.previous()).nodes;
    }

    private int index(Switchable token)
    {
        this.converter.index = -1;
        token.apply(this.converter);
        return this.converter.index;
    }

    @SuppressWarnings("unchecked")
    public Start parse() throws ParserException, LexerException, IOException
    {
        push(0, null, true);
        List<Node> ign = null;
        while(true)
        {
            while(index(this.lexer.peek()) == -1)
            {
                if(ign == null)
                {
                    ign = new LinkedList<Node>();
                }

                ign.add(this.lexer.next());
            }

            if(ign != null)
            {
                this.ignoredTokens.setIn(this.lexer.peek(), ign);
                ign = null;
            }

            this.last_pos = this.lexer.peek().getPos();
            this.last_line = this.lexer.peek().getLine();
            this.last_token = this.lexer.peek();

            int index = index(this.lexer.peek());
            this.action[0] = Parser.actionTable[state()][0][1];
            this.action[1] = Parser.actionTable[state()][0][2];

            int low = 1;
            int high = Parser.actionTable[state()].length - 1;

            while(low <= high)
            {
                int middle = (low + high) / 2;

                if(index < Parser.actionTable[state()][middle][0])
                {
                    high = middle - 1;
                }
                else if(index > Parser.actionTable[state()][middle][0])
                {
                    low = middle + 1;
                }
                else
                {
                    this.action[0] = Parser.actionTable[state()][middle][1];
                    this.action[1] = Parser.actionTable[state()][middle][2];
                    break;
                }
            }

            switch(this.action[0])
            {
                case SHIFT:
		    {
		        ArrayList list = new ArrayList();
		        list.add(this.lexer.next());
                        push(this.action[1], list, false);
                    }
		    break;
                case REDUCE:
                    switch(this.action[1])
                    {
                    case 0: /* reduce AAprogram1Program */
		    {
			ArrayList list = new0();
			push(goTo(0), list, false);
		    }
		    break;
                    case 1: /* reduce AAprogram2Program */
		    {
			ArrayList list = new1();
			push(goTo(0), list, false);
		    }
		    break;
                    case 2: /* reduce AAlol1Lol */
		    {
			ArrayList list = new2();
			push(goTo(1), list, false);
		    }
		    break;
                    case 3: /* reduce AAlol2Lol */
		    {
			ArrayList list = new3();
			push(goTo(1), list, false);
		    }
		    break;
                    case 4: /* reduce ATemp */
		    {
			ArrayList list = new4();
			push(goTo(2), list, false);
		    }
		    break;
                    case 5: /* reduce ATerminal$Lol */
		    {
			ArrayList list = new5();
			push(goTo(3), list, true);
		    }
		    break;
                    case 6: /* reduce ANonTerminal$Lol */
		    {
			ArrayList list = new6();
			push(goTo(3), list, true);
		    }
		    break;
                    case 7: /* reduce ATerminal$Temp */
		    {
			ArrayList list = new7();
			push(goTo(4), list, true);
		    }
		    break;
                    case 8: /* reduce ANonTerminal$Temp */
		    {
			ArrayList list = new8();
			push(goTo(4), list, true);
		    }
		    break;
                    }
                    break;
                case ACCEPT:
                    {
                        EOF node2 = (EOF) this.lexer.next();
                        PProgram node1 = (PProgram) pop().get(0);
                        Start node = new Start(node1, node2);
                        return node;
                    }
                case ERROR:
                    throw new ParserException(this.last_token,
                        "[" + this.last_line + "," + this.last_pos + "] " +
                        Parser.errorMessages[Parser.errors[this.action[1]]]);
            }
        }
    }



    @SuppressWarnings("unchecked")
    ArrayList new0() /* reduce AAprogram1Program */
    {
        @SuppressWarnings("hiding") ArrayList nodeList = new ArrayList();

        PProgram pprogramNode1;
        {
            // Block
        LinkedList listNode2 = new LinkedList();
        {
            // Block
        }

        pprogramNode1 = new AProgram(listNode2);
        }
	nodeList.add(pprogramNode1);
        return nodeList;
    }



    @SuppressWarnings("unchecked")
    ArrayList new1() /* reduce AAprogram2Program */
    {
        @SuppressWarnings("hiding") ArrayList nodeList = new ArrayList();

        @SuppressWarnings("unused") ArrayList nodeArrayList1 = pop();
        PProgram pprogramNode1;
        {
            // Block
        LinkedList listNode3 = new LinkedList();
        {
            // Block
        LinkedList listNode2 = new LinkedList();
        listNode2 = (LinkedList)nodeArrayList1.get(0);
	if(listNode2 != null)
	{
	  listNode3.addAll(listNode2);
	}
        }

        pprogramNode1 = new AProgram(listNode3);
        }
	nodeList.add(pprogramNode1);
        return nodeList;
    }



    @SuppressWarnings("unchecked")
    ArrayList new2() /* reduce AAlol1Lol */
    {
        @SuppressWarnings("hiding") ArrayList nodeList = new ArrayList();

        @SuppressWarnings("unused") ArrayList nodeArrayList3 = pop();
        @SuppressWarnings("unused") ArrayList nodeArrayList2 = pop();
        @SuppressWarnings("unused") ArrayList nodeArrayList1 = pop();
        PLol plolNode1;
        {
            // Block
        TInteger tintegerNode2;
        LinkedList listNode4 = new LinkedList();
        TSemi tsemiNode5;
        @SuppressWarnings("unused") Object nullNode6 = null;
        tintegerNode2 = (TInteger)nodeArrayList1.get(0);
        {
            // Block
        LinkedList listNode3 = new LinkedList();
        listNode3 = (LinkedList)nodeArrayList2.get(0);
	if(listNode3 != null)
	{
	  listNode4.addAll(listNode3);
	}
        }
        tsemiNode5 = (TSemi)nodeArrayList3.get(0);

        plolNode1 = new ALol(tintegerNode2, listNode4, tsemiNode5, null);
        }
	nodeList.add(plolNode1);
        return nodeList;
    }



    @SuppressWarnings("unchecked")
    ArrayList new3() /* reduce AAlol2Lol */
    {
        @SuppressWarnings("hiding") ArrayList nodeList = new ArrayList();

        @SuppressWarnings("unused") ArrayList nodeArrayList4 = pop();
        @SuppressWarnings("unused") ArrayList nodeArrayList3 = pop();
        @SuppressWarnings("unused") ArrayList nodeArrayList2 = pop();
        @SuppressWarnings("unused") ArrayList nodeArrayList1 = pop();
        PLol plolNode1;
        {
            // Block
        TInteger tintegerNode2;
        LinkedList listNode4 = new LinkedList();
        TSemi tsemiNode5;
        TLinestuff tlinestuffNode6;
        tintegerNode2 = (TInteger)nodeArrayList1.get(0);
        {
            // Block
        LinkedList listNode3 = new LinkedList();
        listNode3 = (LinkedList)nodeArrayList2.get(0);
	if(listNode3 != null)
	{
	  listNode4.addAll(listNode3);
	}
        }
        tsemiNode5 = (TSemi)nodeArrayList3.get(0);
        tlinestuffNode6 = (TLinestuff)nodeArrayList4.get(0);

        plolNode1 = new ALol(tintegerNode2, listNode4, tsemiNode5, tlinestuffNode6);
        }
	nodeList.add(plolNode1);
        return nodeList;
    }



    @SuppressWarnings("unchecked")
    ArrayList new4() /* reduce ATemp */
    {
        @SuppressWarnings("hiding") ArrayList nodeList = new ArrayList();

        @SuppressWarnings("unused") ArrayList nodeArrayList2 = pop();
        @SuppressWarnings("unused") ArrayList nodeArrayList1 = pop();
        PTemp ptempNode1;
        {
            // Block
        TOp topNode2;
        TInteger tintegerNode3;
        topNode2 = (TOp)nodeArrayList1.get(0);
        tintegerNode3 = (TInteger)nodeArrayList2.get(0);

        ptempNode1 = new ATemp(topNode2, tintegerNode3);
        }
	nodeList.add(ptempNode1);
        return nodeList;
    }



    @SuppressWarnings("unchecked")
    ArrayList new5() /* reduce ATerminal$Lol */
    {
        @SuppressWarnings("hiding") ArrayList nodeList = new ArrayList();

        @SuppressWarnings("unused") ArrayList nodeArrayList1 = pop();
        LinkedList listNode2 = new LinkedList();
        {
            // Block
        PLol plolNode1;
        plolNode1 = (PLol)nodeArrayList1.get(0);
	if(plolNode1 != null)
	{
	  listNode2.add(plolNode1);
	}
        }
	nodeList.add(listNode2);
        return nodeList;
    }



    @SuppressWarnings("unchecked")
    ArrayList new6() /* reduce ANonTerminal$Lol */
    {
        @SuppressWarnings("hiding") ArrayList nodeList = new ArrayList();

        @SuppressWarnings("unused") ArrayList nodeArrayList2 = pop();
        @SuppressWarnings("unused") ArrayList nodeArrayList1 = pop();
        LinkedList listNode3 = new LinkedList();
        {
            // Block
        LinkedList listNode1 = new LinkedList();
        PLol plolNode2;
        listNode1 = (LinkedList)nodeArrayList1.get(0);
        plolNode2 = (PLol)nodeArrayList2.get(0);
	if(listNode1 != null)
	{
	  listNode3.addAll(listNode1);
	}
	if(plolNode2 != null)
	{
	  listNode3.add(plolNode2);
	}
        }
	nodeList.add(listNode3);
        return nodeList;
    }



    @SuppressWarnings("unchecked")
    ArrayList new7() /* reduce ATerminal$Temp */
    {
        @SuppressWarnings("hiding") ArrayList nodeList = new ArrayList();

        @SuppressWarnings("unused") ArrayList nodeArrayList1 = pop();
        LinkedList listNode2 = new LinkedList();
        {
            // Block
        PTemp ptempNode1;
        ptempNode1 = (PTemp)nodeArrayList1.get(0);
	if(ptempNode1 != null)
	{
	  listNode2.add(ptempNode1);
	}
        }
	nodeList.add(listNode2);
        return nodeList;
    }



    @SuppressWarnings("unchecked")
    ArrayList new8() /* reduce ANonTerminal$Temp */
    {
        @SuppressWarnings("hiding") ArrayList nodeList = new ArrayList();

        @SuppressWarnings("unused") ArrayList nodeArrayList2 = pop();
        @SuppressWarnings("unused") ArrayList nodeArrayList1 = pop();
        LinkedList listNode3 = new LinkedList();
        {
            // Block
        LinkedList listNode1 = new LinkedList();
        PTemp ptempNode2;
        listNode1 = (LinkedList)nodeArrayList1.get(0);
        ptempNode2 = (PTemp)nodeArrayList2.get(0);
	if(listNode1 != null)
	{
	  listNode3.addAll(listNode1);
	}
	if(ptempNode2 != null)
	{
	  listNode3.add(ptempNode2);
	}
        }
	nodeList.add(listNode3);
        return nodeList;
    }



    private static int[][][] actionTable;
/*      {
			{{-1, REDUCE, 0}, {0, SHIFT, 1}, },
			{{-1, ERROR, 1}, {3, SHIFT, 5}, },
			{{-1, ERROR, 2}, {5, ACCEPT, -1}, },
			{{-1, REDUCE, 5}, },
			{{-1, REDUCE, 1}, {0, SHIFT, 1}, },
			{{-1, ERROR, 5}, {0, SHIFT, 9}, },
			{{-1, REDUCE, 7}, },
			{{-1, ERROR, 7}, {2, SHIFT, 10}, {3, SHIFT, 5}, },
			{{-1, REDUCE, 6}, },
			{{-1, REDUCE, 4}, },
			{{-1, REDUCE, 2}, {4, SHIFT, 12}, },
			{{-1, REDUCE, 8}, },
			{{-1, REDUCE, 3}, },
        };*/
    private static int[][][] gotoTable;
/*      {
			{{-1, 2}, },
			{{-1, 3}, {4, 8}, },
			{{-1, 6}, {7, 11}, },
			{{-1, 4}, },
			{{-1, 7}, },
        };*/
    private static String[] errorMessages;
/*      {
			"expecting: integer, EOF",
			"expecting: op",
			"expecting: EOF",
			"expecting: integer",
			"expecting: ';', op",
			"expecting: integer, linestuff, EOF",
        };*/
    private static int[] errors;
/*      {
			0, 1, 2, 0, 0, 3, 4, 4, 0, 4, 5, 4, 0, 
        };*/

    static 
    {
        try
        {
            DataInputStream s = new DataInputStream(
                new BufferedInputStream(
                Parser.class.getResourceAsStream("parser.dat")));

            // read actionTable
            int length = s.readInt();
            Parser.actionTable = new int[length][][];
            for(int i = 0; i < Parser.actionTable.length; i++)
            {
                length = s.readInt();
                Parser.actionTable[i] = new int[length][3];
                for(int j = 0; j < Parser.actionTable[i].length; j++)
                {
                for(int k = 0; k < 3; k++)
                {
                    Parser.actionTable[i][j][k] = s.readInt();
                }
                }
            }

            // read gotoTable
            length = s.readInt();
            gotoTable = new int[length][][];
            for(int i = 0; i < gotoTable.length; i++)
            {
                length = s.readInt();
                gotoTable[i] = new int[length][2];
                for(int j = 0; j < gotoTable[i].length; j++)
                {
                for(int k = 0; k < 2; k++)
                {
                    gotoTable[i][j][k] = s.readInt();
                }
                }
            }

            // read errorMessages
            length = s.readInt();
            errorMessages = new String[length];
            for(int i = 0; i < errorMessages.length; i++)
            {
                length = s.readInt();
                StringBuffer buffer = new StringBuffer();

                for(int j = 0; j < length; j++)
                {
                buffer.append(s.readChar());
                }
                errorMessages[i] = buffer.toString();
            }

            // read errors
            length = s.readInt();
            errors = new int[length];
            for(int i = 0; i < errors.length; i++)
            {
                errors[i] = s.readInt();
            }

            s.close();
        }
        catch(Exception e)
        {
            throw new RuntimeException("The file \"parser.dat\" is either missing or corrupted.");
        }
    }
}