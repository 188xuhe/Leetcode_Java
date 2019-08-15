package test;

import org.junit.*;

public class Template {
        /**
         *
         * 初始化测试资源称为Fixture
         *   @Before和@After：
         *     在@Before方法中初始化测试资源
         *     在@After方法中释放测试资源
         *   @BeforeClass和@AfterClass静态方法：
         *     在执行所有@Test方法前执行@BeforeClass静态方法
         *     在执行所有@Test方法后执行@AfterClass静态方法
         *
         * 执行顺序为：BeforeClass——构造器——Before——TestA——After——...——AfterClass
         *
         */

        @BeforeClass
        public static void setUpBeforeClass() throws Exception {
            System.out.println("setUpBeforeClass()");
        }

        @AfterClass
        public static void tearDownAfterClass() throws Exception {
            System.out.println("tearDownAfterClass()");
        }

        @Before
        public void setUp() throws Exception {
            System.out.println("    setUp()");
        }

        @After
        public void tearDown() throws Exception {
            System.out.println("    tearDown()");
        }

        public Template() {
            System.out.println("  new SequenceTest()");
        }

        @Test
        public void testA() {
            System.out.println("    testA()");
        }

        @Test
        public void testB() {
            System.out.println("    testB()");
        }

        @Test
        public void testC() {
            System.out.println("    testC()");
        }

}

