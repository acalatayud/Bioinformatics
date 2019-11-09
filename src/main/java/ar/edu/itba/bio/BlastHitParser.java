package ar.edu.itba.bio;

import org.biojava.nbio.core.search.io.Hit;
import org.biojava.nbio.core.search.io.Result;
import org.biojava.nbio.core.search.io.blast.BlastXMLParser;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class BlastHitParser {

    public static boolean getHits(final File blast, final String pattern, final boolean toFasta) {
        final List<Hit> hits = getHits(blast);
        if(hits == null) {
            return false;
        }

        final List<Hit> matches;
        if (pattern != null && !pattern.isEmpty()) {
            matches = hits.stream()
                    .filter(h ->
                            h.getHitId().toUpperCase().contains(pattern.toUpperCase()) ||
                                    h.getHitDef().toUpperCase().contains(pattern.toUpperCase()))
                    .collect(Collectors.toList());
        } else {
            matches = hits;
        }

        System.out.println("Matching pattern: " + pattern);
        matches.forEach(hit -> System.out.println("Id: " + hit.getHitId() + " " + hit.getHitDef()));
        System.out.println();
        return true;
    }

    private static List<Hit> getHits(final File blast) {
        final BlastXMLParser blastParser = new BlastXMLParser();
        blastParser.setFile(blast);
        try {
            final List<Result> results = blastParser.createObjects(10);
            return StreamSupport.stream(results.get(0).spliterator(), false).collect(Collectors.toList());
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
}
