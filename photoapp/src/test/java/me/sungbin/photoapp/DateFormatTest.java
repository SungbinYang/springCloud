package me.sungbin.photoapp;

import me.sungbin.photoapp.storage.FileWriter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//@SpringBootTest
//@ExtendWith(SpringExtension.class)
public class DateFormatTest {
    @Test
  void fileWriteGenerateDate() {
        //given
        String expectdDate = FileWriter.dateStr();
        //then
        System.out.println(FileWriter.dateStr());
        Assertions.assertNotNull(expectdDate);
  }
}
