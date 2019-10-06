package ar.edu.itba.bio;

import org.biojava.nbio.core.sequence.DNASequence;
import org.biojava.nbio.core.sequence.ProteinSequence;
import org.biojava.nbio.core.sequence.RNASequence;
import org.biojava.nbio.core.sequence.io.FastaWriterHelper;
import org.biojava.nbio.core.sequence.io.GenbankReaderHelper;
import org.biojava.nbio.core.sequence.transcription.Frame;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class GenBankTranslator {

    public static boolean translate(final File genBank, final String output) {
        final boolean result;
        try {
            final Map<String, DNASequence> auxSequences = GenbankReaderHelper.readGenbankDNASequence(genBank);
            final Map<Frame, RNASequence> sequences = getRNASequences(auxSequences);
            final List<ProteinSequence> proteinSequences = translateToProteins(sequences);
            result = saveAsFasta(proteinSequences, output);
        } catch (Exception e) {
            return false;
        }
        return result;
    }

    private static Map<Frame, RNASequence> getRNASequences(Map<String, DNASequence> auxSequences) {
        final Frame[] allFrames = Frame.getAllFrames();
        final Map<Frame, RNASequence> sequences = new HashMap<>();
        auxSequences.forEach((key, value) -> Arrays.stream(allFrames).forEachOrdered(f -> {
            final RNASequence rnaSequence = value.getRNASequence(f);
            rnaSequence.setOriginalHeader(key);
            sequences.put(f, rnaSequence);
        }));
        return sequences;
    }

    private static List<ProteinSequence> translateToProteins(final Map<Frame, RNASequence> rnaSequences) {

        return rnaSequences.entrySet().stream()
                .map(s -> {
                    final ProteinSequence proteinSequence = s.getValue().getProteinSequence();
                    proteinSequence.setOriginalHeader(s.getValue().getOriginalHeader() + " - FRAME " + s.getKey().name());
                    return proteinSequence;
                })
                .collect(Collectors.toList());
    }

    private static boolean saveAsFasta(final List<ProteinSequence> proteins, final String filename) {
        final File file = new File(filename + ".fas");
        try {
            final boolean created = file.createNewFile();
            if(!created && !file.canWrite()) {
                return false;
            }
        } catch (IOException e) {
            return false;
        }

        try {
            FastaWriterHelper.writeProteinSequence(file, proteins);
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
