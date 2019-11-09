package ar.edu.itba.bio;

import org.apache.commons.io.FileUtils;
import org.biojava.nbio.core.sequence.ProteinSequence;
import org.biojava.nbio.core.sequence.io.FastaReaderHelper;
import org.biojava.nbio.ws.alignment.qblast.*;

import java.io.*;
import java.util.Map;

public class BlastReporter {

    public static boolean execute(final File fasta, final String output) {
        boolean result = true;
        try {
            final Map<String, ProteinSequence> sequences = FastaReaderHelper.readFastaProteinSequence(fasta);

            final NCBIQBlastService service = new NCBIQBlastService();

            final NCBIQBlastAlignmentProperties props = new NCBIQBlastAlignmentProperties();
            props.setBlastProgram(BlastProgramEnum.blastp);
            props.setBlastDatabase("swissprot");

            final NCBIQBlastOutputProperties outputProps = new NCBIQBlastOutputProperties();
            //outputProps.setOutputFormat(BlastOutputFormatEnum.Text);

            for (final ProteinSequence sequence : sequences.values()) {
                final String rid = service.sendAlignmentRequest(sequence.getSequenceAsString(), props);
                final InputStream response = service.getAlignmentResults(rid, outputProps);
                result &= saveAsBlast(response, output + "_" + sequence.getOriginalHeader());
                service.sendDeleteRequest(rid);
            }

        } catch (Exception e) {
            return false;
        }

        return result;
    }

    private static boolean saveAsBlast(final InputStream response, final String filename) {
        final File file = new File(filename + ".out");
        try {
            final boolean created = file.createNewFile();
            if(!created && !file.canWrite()) {
                return false;
            }
        } catch (IOException e) {
            return false;
        }

        try {
            FileUtils.copyInputStreamToFile(response, file);
        } catch (IOException e) {
            return false;
        }

        return true;
    }
}
