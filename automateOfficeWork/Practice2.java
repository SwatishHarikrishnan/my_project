package automateOfficeWork;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import io.cucumber.core.gherkin.messages.internal.gherkin.Func;
import io.cucumber.messages.internal.com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;
public class Practice2 {

	
	
public static void main(String[] args) throws IOException {

List<String> listofall = new ArrayList<String>();
listofall.add("MAY_01");
listofall.add("MAY_02");
listofall.add("MAY_01");
listofall.add("MAY_02");

List<Integer> valueofall = new ArrayList<Integer>();
valueofall.add(2);
valueofall.add(5);
valueofall.add(5);
valueofall.add(10);

Map<String, Integer> map = new HashMap<String, Integer>();

for(int i=0;i<listofall.size();i++)
{
if(map.containsKey(listofall.get(i)))
{
	map.put(listofall.get(i), valueofall.get(i)+map.get(listofall.get(i)));
}
else
{
	map.put(listofall.get(i), valueofall.get(i));
}
}
System.out.println(map);
	}
}
