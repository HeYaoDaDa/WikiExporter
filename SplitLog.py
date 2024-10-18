import os
import re
import shutil

log_path = "/opt/starsector_097_zh/starsector.log"
folder_path = "jsons"
if os.path.exists(folder_path):
    for filename in os.listdir(folder_path):
        file_path = os.path.join(folder_path, filename)
        try:
            if os.path.isfile(file_path) or os.path.islink(file_path):
                os.unlink(file_path)
            elif os.path.isdir(file_path):
                shutil.rmtree(file_path)
        except Exception as e:
            print("无法删除 %s。原因: %s" % (file_path, e))
else:
    os.makedirs(folder_path)
pattern = re.compile(r"export_(\S+)_export_(.+)$")
with open(log_path, "r") as file:
    for line in file:
        match = pattern.search(line)
        if match:
            filename = os.path.join(folder_path, match.group(1) + ".json")
            content = match.group(2)
            try:
                with open(filename, "w") as outfile:
                    outfile.write(content)
                print(f'File "{filename}" saved successfully.')
            except IOError as e:
                print(f'Error saving file "{filename}": {e}')