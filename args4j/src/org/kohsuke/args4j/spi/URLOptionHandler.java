package org.kohsuke.args4j.spi;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.OptionDef;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * {@link URL} {@link OptionHandler}.
 *
 * @author Kohsuke Kawaguchi
 */
public class URLOptionHandler extends OptionHandler<URL> {
    public URLOptionHandler(CmdLineParser parser, OptionDef option, Setter<? super URL> setter) {
        super(parser, option, setter);
    }

    @Override
    public int parseArguments(Parameters params) throws CmdLineException {
        String param = params.getParameter(0);
        try {
            setter.addValue(new URL(param));
            return 1;
        } catch (MalformedURLException e) {
            throw new CmdLineException(Messages.ILLEGAL_OPERAND.format(param));
        }
    }

    @Override
    public String getDefaultMetaVariable() {
        return "URL";
    }
}
