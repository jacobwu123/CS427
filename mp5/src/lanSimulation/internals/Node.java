/*   This file is part of lanSimulation.
 *
 *   lanSimulation is free software; you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation; either version 2 of the License, or
 *   (at your option) any later version.
 *
 *   lanSimulation is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with lanSimulation; if not, write to the Free Software
 *   Foundation, Inc. 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 *
 *   Copyright original Java version: 2004 Bart Du Bois, Serge Demeyer
 *   Copyright C++ version: 2006 Matthias Rieger, Bart Van Rompaey
 */
package lanSimulation.internals;

import java.io.IOException;
import java.io.Writer;

/**
 * A <em>Node</em> represents a single Node in a Local Area Network (LAN).
 * Several types of Nodes exist.
 */
public class Node {
    // enumeration constants specifying all legal node types
    /**
     * A node with type NODE has only basic functionality.
     */
    //public static final byte NODE = 0;
    /**
     * A node with type WORKSTATION may initiate requests on the LAN.
     */
  //  public static final byte WORKSTATION = 1;
    /**
     * A node with type PRINTER may accept packages to be printed.
     */
  //  public static final byte PRINTER = 2;

    /**
     * Holds the type of the Node.
     */
   // public byte type;
    /**
     * Holds the name of the Node.
     */
    public String name;
    /**
     * Holds the next Node in the token ring architecture.
     *
     * @see lanSimulation.internals.Node
     */
    public Node nextNode;

    /**
     * Construct a <em>Node</em> with given #type and #name.
     */
    public Node(String _name) {
//        assert (_type >= NODE) & (_type <= PRINTER);
//        type = _type;
        name = _name;
        nextNode = null;
    }

    /**
     * Construct a <em>Node</em> with given #type and #name, and which is linked
     * to #nextNode.
     */
    public Node(String _name, Node _nextNode) {
//        assert (_type >= NODE) & (_type <= PRINTER);
//        type = _type;
        name = _name;
        nextNode = _nextNode;
    }

    /**
     * Write printable representation of #node to #report.
     *
     * @param report
     */
    public void logNodePass(Writer report) throws IOException {
        report.write("\tNode '");
        report.write(name);
        report.write("' passes packet on.\n");
        report.flush();
    }

    public boolean printDocument(Packet document, Writer report) {
            try {
                report.write(">>> Destination is not a printer, print job canceled.\n\n");
                report.flush();
            } catch (IOException exc) {
                // just ignore
            }
            return false;
    }

    /**
     * Append a printable representation of #Node on the given #buf.
     *
     * @param buf
     */
    public void printOn(StringBuffer buf) {
        buf.append("Node ");
        buf.append(name);
        buf.append(" [Node]");
    }

    /**
     * Append a printable representation of #Node on the given #buf.
     *
     * @param buf
     */
    public void printHTMLOn(StringBuffer buf) {
        buf.append("Node ");
        buf.append(name);
        buf.append(" [Node]");
    }

    public void printXMLOn(StringBuffer buf) {
        buf.append("<node>");
        buf.append(name);
        buf.append("</node>");
    }
}