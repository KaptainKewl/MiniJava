/* This file was generated by SableCC (http://www.sablecc.org/). */

package simpleAdder.analysis;

import simpleAdder.node.*;

public interface Analysis extends Switch
{
    Object getIn(Node node);
    void setIn(Node node, Object o);
    Object getOut(Node node);
    void setOut(Node node, Object o);

    void caseStart(Start node);
    void caseAProgram(AProgram node);
    void caseALol(ALol node);
    void caseATemp(ATemp node);

    void caseTInteger(TInteger node);
    void caseTId(TId node);
    void caseTSemi(TSemi node);
    void caseTOp(TOp node);
    void caseTWhitespace(TWhitespace node);
    void caseTLinestuff(TLinestuff node);
    void caseEOF(EOF node);
}
