package com.xenoterracide.bsdata.client;

import static org.assertj.core.api.Assertions.assertThat;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import net.battlescribe.schema.catalogueschema.Catalogue;
import org.junit.jupiter.api.Test;

class LoadSchemaTest {

  @Test
  void unmarshal() throws JAXBException {
    var unmarshaller = JAXBContext.newInstance(Catalogue.class.getPackageName()).createUnmarshaller();

    var cat = (Catalogue) ((JAXBElement) unmarshaller.unmarshal(
        getClass().getResourceAsStream("/ChaosKnightsLibrary.xml")
      )).getValue();
    assertThat(cat.getName()).isEqualTo("Chaos - Chaos Knights Library");
  }
}
