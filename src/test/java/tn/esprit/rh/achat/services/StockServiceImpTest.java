package tn.esprit.rh.achat.services;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.*;
@SpringBootTest(classes =StockServiceImplMockTest.class)
@ExtendWith(MockitoExtension.class)
  class StockServiceImplMockTest {
 @Mock
 StockRepository stockRepository;

 @InjectMocks
 StockServiceImpl stockServiceImp;

 Stock stock = new Stock("f1", 1,2);

 List<Stock> listStocks = new ArrayList<Stock>() {
  {
   add(new Stock("f1aa", 2,4));
   add(new Stock("f1f", 4,7));
  }
 };
 @Test
  void testRetrieveStock() {
  Mockito.when(stockRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(stock));
  Stock stock1 = stockServiceImp.retrieveStock(1L);
  Assertions.assertNotNull(stock1);
 }


    @Test
    void testRetrieveStockByid() {
        when(stockRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(stock));
        Stock stockq = stockServiceImp.retrieveStock(1L);
     System.out.println(stockq);
        Assertions.assertNotNull(stockq);
    }
    @Test
    void testRetrieveAllStock() {
        Mockito.when(stockRepository.findAll()).thenReturn(listStocks);
        List<Stock> s = stockServiceImp.retrieveAllStocks();
        assertEquals(2, s.size());
    }
    @Test
    void testCreateNewObject() {
        Mockito.when(stockRepository.save(stock)).thenReturn(stock);
        Stock s = stockServiceImp.addStock(stock);
        assertNotNull(s);
    }
    


}