#!/usr/bin/env python3
"""MySQL integration test runner for Aurelium.

This script starts a MySQL-backed Paper server and validates
Aurelium's database integration.
"""

import subprocess
import sys
import time
import os

def main() -> int:
    """Run MySQL integration tests."""
    script_dir = os.path.dirname(os.path.abspath(__file__))
    repo_root = os.path.dirname(script_dir)

    server_jar = os.path.join(repo_root, '..', 'paper.jar')
    if not os.path.exists(server_jar):
        print(f"Server jar not found: {server_jar}", file=sys.stderr)
        return 1

    process = subprocess.Popen(
        ['java', '-jar', server_jar, '--nogui'],
        cwd=repo_root,
        stdout=subprocess.PIPE,
        stderr=subprocess.STDOUT,
        text=True
    )

    try:
        time.sleep(10)
        result = subprocess.run(
            [sys.executable, os.path.join(script_dir, 'rcon_client.py'), 'status'],
            capture_output=True,
            text=True
        )
        print(result.stdout)
        if result.stderr:
            print(result.stderr, file=sys.stderr)
        return result.returncode
    finally:
        process.terminate()
        process.wait()


if __name__ == '__main__':
    sys.exit(main())
