package trng.excptnHndlng.suppressed;
public class SuppressedExceptionDemoWithTryWithResource
{
   /**
    * Demonstrating suppressed exceptions using try-with-resources
    */
   public static void main(String[] arguments) throws Exception
   {
      try (DirtyResource resource= new DirtyResource())
      {
          resource.accessResource();
      }
   }
}